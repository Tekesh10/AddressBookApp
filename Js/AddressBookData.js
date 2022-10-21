class AddressBookData {
    get id() {
        return this._id;
    }

    set id(id) {
        this._id = id;
    }

    get name() {
        return this._name;
    }

    set name(name) {
        const nameRegex = RegExp('^[A-Z]{1}[a-z]{2,}');
        if (nameRegex.test(name)) {
            this._name = name;
        } else {
            throw "Invalid Name";
        }
    }

    get phone() {
        return this._phone;
    }

    set phone(phone) {
        const phoneRegex = RegExp('^[+][1-9]{2}[0-9]{10}$');
        if (phoneRegex.test(phone)) {
            this._phone = phone;
        } else {
            throw " Invalid Phone number ";
        }
    }

    get address() {
        return this._address;
    }

    set address(address) {
        const addressRegex = RegExp('^[A-Za-z0-9/.,-]{3,}');
        if (addressRegex.test(address)) {
            this._address = address;
        } else {
            throw "Invalid address";
        }
    }

    get state() {
        return this._state;
    }

    set state(state) {
        this._state = state;
    }

    get city() {
        return this._city;
    }

    set city(city) {
        this._city = city;
    }

    get zipcode() {
        return this._zipcode;
    }

    set zipcode(zipcode) {
        this._zipcode = zipcode;
    }

    toString() {
        return "id : " + this.id + ", Name : " + this.name + ", Address : " + this.address + ", Phone : " + this.phoneNumber +
            ", State : " + this.state + ", City : " + this.city + ", ZipCode : " + this.zipcode;
    }
}