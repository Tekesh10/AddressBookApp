let addressBookList;
window.addEventListener('DOMContentLoaded', () => {
    addressBookList = getDataFromStorage();
    document.querySelector(".person-count").textContent = addressBookList.length;
    createInnerHTML();
    localStorage.removeItem("edit-person");
})

/** UC4 section 2  populate data from local storage in home page table */
const getDataFromStorage = () => {
    return localStorage.getItem('AddressBookList') ?
        JSON.parse(localStorage.getItem('AddressBookList')) : [];
}

const createInnerHTML = () => {
    const headerHtml = `
    <tr>
        <th>Fullname</th>
        <th>Address</th>
        <th>City</th>
        <th>State</th>
        <th>Zip Code</th>
        <th>Phone Number</th>
    </tr>`;
    if (addressBookList.length == 0) return;
    let innerHtml = `${headerHtml}`;
    for (const contactData of addressBookList) {
        innerHtml = `${innerHtml}
        <tr>
            <td>${contactData._name}</td>
            <td>${contactData._address}</td>
            <td>${contactData._city}</td>
            <td>${contactData._state}</td>
            <td>${contactData._zipcode}</td>
            <td>${contactData._phone}</td>
            <td>
            <img id="${contactData._id}" alt="edit" src="/Assets/edit.png" onClick=update(this)>
            <img id="${contactData._id}" alt="delete" src="/Assets/delete.png" onClick=remove(this)>
            </td>
        </tr>
        `;
    }
    document.querySelector('#display').innerHTML = innerHtml;
}

//UC5-Remove data
const remove = (data) => {
    let deletePerson = addressBookList.find(contactData => contactData._id == data.id);
    if (!deletePerson)
        return;
    const index = addressBookList.map(contactData => contactData._id).indexOf(deletePerson._id);
    addressBookList.splice(index, 1);
    localStorage.setItem('AddressBookList', JSON.stringify(addressBookList));
    document.querySelector(".person-count").textContent = addressBookList.length;
    createInnerHTML();
    alert("Person data deleted successfully..!");
}


// //UC6 -Update data
const update = (data) => {
    let updatePerson = addressBookList.find(contactData => contactData._id == data.id);
    if (!updatePerson)
        return;
    localStorage.setItem('edit-person', JSON.stringify(updatePerson));
    window.location.replace(site_properties.addBook);
}