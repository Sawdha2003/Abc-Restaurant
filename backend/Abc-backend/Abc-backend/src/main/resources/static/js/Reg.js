const username = document.getElementById('username');
const email = document.getElementById('email');
const password = document.getElementById('password');
const role = document.getElementById('role');
const formsubmit = document.getElementById('formsubmit');

const usernameError = document.getElementById('username-error');
const emailError = document.getElementById('email-error');
const passwordError = document.getElementById('password-error');
const roleError = document.getElementById('role-error');

const email_check = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;

formsubmit.addEventListener('submit', async (e) => {
    e.preventDefault(); // Prevent the default form submission

    let hasError = false;

    // Validate the form
    if (username.value.trim() === '') {
        usernameError.textContent = "Username is required";
        hasError = true;
    } else {
        usernameError.textContent = '';
    }

    if (!email.value.match(email_check)) {
        emailError.textContent = "A valid Email is required";
        hasError = true;
    } else {
        emailError.textContent = '';
    }

    if (password.value.length < 6) {
        passwordError.textContent = "Password must be more than 6 characters";
        hasError = true;
    } else {
        passwordError.textContent = '';
    }

    // If there are no validation errors, proceed with the fetch request
    if (!hasError) {
        const formData = {
            username: username.value,
            email: email.value,
            password: password.value,
            role: role.value,
        };

        try {
            const response = await fetch('http://localhost:8080/register', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(formData),
            });

            if (response.status === 201) {
                showNotification("Registration completed successfully!", "success");

                // Redirect to another page after successful registration
                setTimeout(() => {
                    window.location.href = "/welcome";
                }, 2000); // Redirect after 2 seconds
            } else if (response.status === 409) {
                showNotification("Username already taken.", "error");
            } else {
                const errorText = await response.text();
                showNotification(errorText || "Registration failed. Try again later.", "error");
            }
        } catch (error) {
            showNotification("An error occurred: " + error.message, "error");
        }
    }
});

function showNotification(message, type) {
    const notification = document.getElementById('notification');
    notification.textContent = message;
    notification.className = `notification ${type}`;
    setTimeout(() => {
        notification.textContent = '';
        notification.className = 'notification';
    }, 3000); // Clear notification after 3 seconds
}
