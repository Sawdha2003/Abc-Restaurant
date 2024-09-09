document.addEventListener('DOMContentLoaded', () => {
    fetch("http://localhost:8080/products")
        .then(response => response.json())
        .then(data => {
            let rows = '';
            data.forEach(product => {
                rows += `<tr>
                    <td>${product.productname}</td>
                    <td>${product.description}</td>
                    <td>${product.price}</td>
                    <td>${product.quantity}</td>
                    <td>${product.category}</td>
                    <td><img src="${product.imageUrl}" alt="${product.productname}"/></td>
                    <td class="Action">
                        <button onclick="editProduct('${product.id}')">Edit</button>
                        <button onclick="deleteProduct('${product.id}')">Delete</button>
                        <button onclick="window.location.href='/add-product'">Add Product</button>
                    </td>
                </tr>`;
            });
            document.getElementById('tablerows').innerHTML = rows;
        })
        .catch(error => {
            console.error("Error fetching and processing products:", error);
        });
});

function deleteProduct(id) {
    console.log("Deleting product with ID:", id);

    if (!confirm("Are you sure you want to delete the product?")) {
        return;
    }

    fetch(`http://localhost:8080/products/${id}`, { 
        method: 'DELETE'
    })
    .then(response => {
        if (response.ok) {
            const row = document.querySelector(`button[onclick="deleteProduct('${id}')"]`).closest('tr');
            row.remove();
            alert("Product deleted successfully!");
        } else {
            response.json().then(error => {
                alert("Product failed to delete: " + (error.message || "Unknown error"));
            });
        }
    })
    .catch(error => {
        console.error("Error deleting product:", error);
        alert("An error occurred while deleting the product.");
    });
}
