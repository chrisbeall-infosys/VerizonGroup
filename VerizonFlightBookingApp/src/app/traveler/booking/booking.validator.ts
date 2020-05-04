import { AbstractControl } from '../../../../node_modules/@angular/forms';


export class DateValidator{
    static today(control:AbstractControl) : {'today':true | null}{
        let today = new Date();
        return (Date.parse(control.value) > today.valueOf()) ? null:{'today': true};
    }

    static year(control:AbstractControl) : {'month': false | true}{
        
        let oneYear:Date = new Date();
        oneYear.setDate(oneYear.getDate()+365);
        return (Date.parse(control.value) < oneYear.valueOf()) ? null:{'month': true};
    }
  

}