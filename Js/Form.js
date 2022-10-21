let isUpdate = false;
addressBookObject = {};
window.addEventListener('DOMContentLoaded', (event) => {
    validationOnField();
    editForm();
})

function validationOnField() {
    const name = document.querySelector('#name');
    const phone = document.querySelector('#phone');
    const address = document.querySelector('#address');
    const nameError = document.querySelector('.name-error');
    const phoneError = document.querySelector('.phone-error');
    const addressError = document.querySelector('.address-error');
    name.addEventListener('input', function () {
        try {
            let contactData = new AddressBookData();
            contactData.name = name.value;
            nameError.textContent = "";
        } catch (e) {
            nameError.textContent = e;
        }
    });
    phone.addEventListener('input', function () {
        try {
            let contactData = new AddressBookData();
            contactData.phone = phone.value;
            phoneError.textContent = "";
        } catch (e) {
            phoneError.textContent = e;
        }
    });
    address.addEventListener('input', function () {
        try {
            let contactData = new AddressBookData();
            contactData.address = address.value;
            addressError.textContent = "";
        } catch (e) {
            addressError.textContent = e;
        }
    });
}

const save = (event) => {
    event.preventDefault();
    event.stopPropagation();
    let addressBook = createAddressBook();
    addAndUpdateLocalStorage(addressBook);
    alert("Contact added of : " + addressBook._name);
    window.location.replace(site_properties.home);
}
const createAddressBook = () => {
    let addressBook = new AddressBookData();
    addressBook.name = getInputValueId("#name");
    addressBook.phone = getInputValueId("#phone");
    addressBook.address = getInputValueId("#address");
    addressBook.city = getInputValueId("#city");
    addressBook.state = getInputValueId("#state");
    addressBook.zipcode = getInputValueId("#zipcode");
    addressBook.id = addressBookObject._id;
    return addressBook;
}
const getInputValueId = (id) => {
    return document.querySelector(id).value;
}
const createNewPersonId = () => {
    let personId = localStorage.getItem('personId');
    personId = !personId ? 1 : (parseInt(personId) + 1).toString();
    localStorage.setItem('personId', personId);
    return personId;
}
const addAndUpdateLocalStorage = (data) => {
    let personList = JSON.parse(localStorage.getItem("AddressBookList"));
    if (personList) {
        let existingcontactData = personList.find(contactData => contactData._id == data.id);
        if (!existingcontactData) {
            data.id = createNewPersonId();
            personList.push(data);
        } else {
            const index = personList.map(person => person._id).indexOf(data.id);
            personList.splice(index, 1, data);
        }
    } else {
        data.id = createNewPersonId();
        personList = [data];
    }
    localStorage.setItem('AddressBookList', JSON.stringify(personList));
}
const editForm = () => {
    let jsonData = localStorage.getItem('edit-person');
    isUpdate = jsonData ? true : false;
    if (!isUpdate)
        return;
    addressBookObject = JSON.parse(jsonData);
    setForm();
}
const setForm = () => {
    setValue('#name', addressBookObject._name);
    setValue('#phone', addressBookObject._phone);
    setValue('#address', addressBookObject._address);
    setValue('#city', addressBookObject._city);
    setValue('#state', addressBookObject._state);
    setValue('#zipcode', addressBookObject._zipcode);
}
const setValue = (id, value) => {
    let element = document.querySelector(id);
    element.value = value;
}
const cancel = () => {
    window.location.replace(site_properties.home);
}
const reset = () => {
    setValue('#name', '');
    setTextValue('.text-error', '');
    setValue('#address', '');
    setTextValue('.address-error', '');
    setValue('#city', 'Select City');
    setValue('#state', 'Select State');
    setValue('#zipcode', '');
    setTextValue('.zip-error', '');
    setValue('#phone', '');
    setTextValue('.phone-error', '');
    alert("Data reseted");
}
const setTextValue = (id, message) => {
    const textError = document.querySelector(id);
    textError.textContent = message;
}