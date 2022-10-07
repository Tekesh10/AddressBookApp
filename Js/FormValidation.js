window.addEventListener('DOMContentLoaded', (event) => {
    validName();
    validPhoneNumber();
    validAddress();
});


function validName() {
    const name = document.querySelector('#name');
    const textError = document.querySelector('.text-error');
    name.addEventListener('input', function () {
        const nameRegex = RegExp('^[A-Z]{1}[a-z]{2,}$');
        if (nameRegex.test(name.value)) {
            textError.textContent = "";
        } else {
            textError.textContent = "Name is incorrect";
        }
    });

}

function validPhoneNumber() {
    const phoneNumber = document.querySelector('#phone');
    const phoneError = document.querySelector('.phone-error');
    phoneNumber.addEventListener('input', function () {
        const phoneRegex = RegExp('^[0-9]{10}$');
        if (phoneRegex.test(phoneNumber.value)) {
            phoneError.textContent = "";
        } else {
            phoneError.textContent = "Phone number is incorrect";
        }
    });
}

function validAddress() {
    const address = document.querySelector('#address');
    const addressError = document.querySelector('.address-error');
    address.addEventListener('input', function () {
        const addressRegex = RegExp('^^([A-Za-z0-9/.,-]{3,}.)+$');
        if (addressRegex.test(address.value)) {
            addressError.textContent = "";
        } else {
            addressError.textContent = "Address is incorrect";
        }
    });
}

//save method
const save = () => {
    alert("Save button");
}

//reset method
const reset = () => {
    alert("Reset button");
}