
let Registerered=false; 

document.querySelector("form").addEventListener("submit", function (e) {


    if(!Registered){
        alert("You need to Login to Submit the Message");


        let loginandregister=confirm("Would you like to login?");


        if(loginanddregister){

            windows.location.href="Login.html";
        }

        
    }


const name=document.querySelector("input[type='text']");
const email=document.querySelector("input[type='email']");
const message=document.querySelector("textarea")



if(name==""){
    alert(" Please Enter your name");

    e.preventDefault();
    return;
    
}

if(email==""){

    alert("Please Enter the Email");

    e.preventDefault();
    return;
}

const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailPattern.test(email)) {
        alert("Please enter a valid email address.");
        e.preventDefault(); 
        return;
    }

    if (message === "") {
        alert("Please enter your message.");
        e.preventDefault();
        return;
    }


    alert("Message sent successfully!");
});