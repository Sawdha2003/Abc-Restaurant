document.addEventListener("DOMContentLoaded", function() {
    fetchUsers();
});

// Fetch all users from the server
function fetchUsers() {
    fetch('/all-users')
        .then(response => response.json())
        .then(users => {
            const tableBody = document.querySelector("#users-table tbody");
            tableBody.innerHTML = ''; // Clear the table

            users.forEach(user => {
                const row = document.createElement('tr');

                row.innerHTML = `
                    <td>${user.id}</td>
                    <td>${user.username}</td>
                    <td>${user.password}</td>
                    <td>${user.email}</td>
                    <td>${user.role}</td>
                    <td>
                        <button class="action-btn edit-btn" onclick="editUser('${user.id}')">Edit</button>
                        <button class="action-btn delete-btn" onclick="deleteUser('${user.id}')">Delete</button>
                    </td>
                `;

                tableBody.appendChild(row);
            });
        })
        .catch(error => console.error('Error fetching users:', error));
}

// Delete user
function deleteUser(id) {
    if (confirm("Are you sure you want to delete this user?")) {
        fetch(`/users/${id}`, {
            method: 'DELETE',
        })
        .then(response => {
            if (response.ok) {
                alert('User deleted successfully');
                fetchUsers(); // Refresh the table
            } else {
                alert('Failed to delete user');
            }
        })
        .catch(error => console.error('Error deleting user:', error));
    }
}

// Edit user
function editUser(id) {
    const newRole = prompt("Enter new role (Admin or Customer):");

    if (newRole && (newRole === 'Admin' || newRole === 'Customer')) {
        fetch(`/users/${id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ role: newRole })
        })
        .then(response => {
            if (response.ok) {
                alert('User updated successfully');
                fetchUsers(); // Refresh the table
            } else {
                alert('Failed to update user');
            }
        })
        .catch(error => console.error('Error updating user:', error));
    } else {
        alert('Invalid role. Only "Admin" or "Customer" are allowed.');
    }
}