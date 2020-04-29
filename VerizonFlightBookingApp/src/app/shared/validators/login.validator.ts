
import { AbstractControl } from '@angular/forms'

export class LoginValidators {
    static validateEmail(control: AbstractControl): any {
        let emailPattern: RegExp = /[a-zA-Z0-9]+@[a-zA-Z]+\.[a-zA-Z]+/;
        if (!emailPattern.test(control.value)) {
            return { "emailPatternError": true }
        }
        return null;
    }
    static validateLoginId(control: AbstractControl): any {
        //[a-zA-Z0-9]{6,15}
        let loginIdPattern: RegExp = /[a-zA-Z0-9]{6,15}/;
        //let valid = control.value.length >=6 && control.value.length <= 15;
        if (!loginIdPattern.test(control.value)) {
            return { "loginIdLengthError": true }
        }
        return null;
    }

    static validateName(control: AbstractControl): any {
        let namePattern1: RegExp = /^[a-zA-Z ]+/;
        let namePattern2: RegExp = /^[^ ].*/;
        let namePattern3: RegExp = /.*[^ ]$/;
        let value = control.value;
        let matches: boolean = namePattern1.test(value) && namePattern2.test(value) && namePattern3.test(value);

        if (!matches) {
            return { "namePatternError": true }
        }
        return null;
    }

    static validatePassword(control: AbstractControl): any {
        let pattern1: RegExp = /^.*[A-Z]+.*/;
        let pattern2: RegExp = /^.*[a-z]+.*/;
        let pattern3: RegExp = /.*[\d]+.*/;
        let pattern4: RegExp = /.*[@#$%&*^]+.*/;
        let value = control.value;
        let matches: boolean = pattern1.test(value) && pattern2.test(value) && pattern3.test(value)
            && pattern4.test(value);

        if (!matches) {
            return { "passwordPatternError": true }
        }
        return null;
    }

}