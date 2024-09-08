document.addEventListener('DOMContentLoaded',function(){

    fetch("http://localhost:8080/Dinein/pending")

    .then(response => response.json())
        .then(data => {
            const tableBody = document.getElementById('tablerows');
            data.forEach(reservation => {
                const row = document.createElement('tr');
                row.innerHTML = `
                    <td>${Dinein.date}</td>
                    <td>${Dinein.time}</td>
                    <td>${Dinein.numberOfGuests}</td>
                    <td>${Dinein.name}</td>
                    <td>${Dinein.phoneNumber}</td>
                    <td>${Dinein.email}</td>
                    <td>${Dinein.location}</td>
                    <td>${Dienein.status}</td>
                `;
                tableBody.appendChild(row);
            });

            document.getElementById('tablerows').innerHTML = rows;
        })
        .catch(error => {
            console.error("Error fetching and processing products:", error);
});


})