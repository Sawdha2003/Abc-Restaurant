document.addEventListener('DOMContentLoaded', () => {
    fetch("/products")
        .then(response => response.json())
        .then(res => {
            const data = res.product;
            let rows = '';
            data.forEach(product => {
                rows += `<tr>
                    <td>${product.Productname}</td>
                    <td>${product.Description}</td>
                    <td>${product.Price}</td>
                    <td>${product.Quantity}</td>
                    <td>${product.Category}</td>
                    <td><img src="${product.imageUrl}" alt="${product.Productname}"/></td>
                    <td class="Action">
                        <button onclick="editProduct('${product.id}')">Edit</button>
                        <button onclick="deleteProduct('${product.id}')">Delete</button>
                    </td>
                </tr>`;
            });
            console.log(rows);
            document.getElementById('tablerows').innerHTML = rows;
        })
        .catch(error => {
            console.error("Error fetching and processing products:", error);
        });
});
