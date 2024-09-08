const date = document.getElementById("date");
const time = document.getElementById("time");
const guest = document.getElementById("guest");
const name = document.getElementById("name");
const phoneNumber = document.getElementById("phone-number");
const email = document.getElementById("email");
const location = document.getElementById("location");
const dineForm = document.getElementById("dine-in-form");

dineForm.addEventListener('submit', (e) => {
    e.preventDefault();

    const DineinDate = {
        Date: date.value,
        Time: time.value,
        Guest: guest.value,
        Name: name.value,
        Number: phoneNumber.value,
        Email: email.value,
        Location: location.value,
        
    };

    fetch('http://localhost:8080/Dinein/Add',{
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(formData)
    })
    then(response => response.json())
    .then(data => {
        if (data.success) {
            showNotification("Reservation completed successfully!", "success");
          
        } else {
            showNotification("Registration failed. Try again later.", "error");
        }
    })
    

})