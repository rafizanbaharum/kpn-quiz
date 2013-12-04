var Register = function () {
    var runSetDefaultValidation = function () {
        $.validator.addMethod('nricNo', function (value) {
                return /^\d{12}$/.test(value);
            },
            'Please enter a valid NRIC no. wtihout dash. eg: 671218045678');

        $.validator.setDefaults({
            errorElement: "span", // contain the error msg in a small tag
            errorClass: 'help-block',
            errorPlacement: function (error, element) { // render error placement for each input type
                if (element.attr("type") == "radio" || element.attr("type") == "checkbox") { // for chosen elements, need to insert the error after the chosen container
                    error.insertAfter($(element).closest('.form-group').children('div').children().last());
                } else if (element.attr("name") == "card_expiry_mm" || element.attr("name") == "card_expiry_yyyy") {
                    error.appendTo($(element).closest('.form-group').children('div'));
                } else {
                    error.insertAfter(element);
                    // for other inputs, just perform default behavior
                }
            },
            ignore: ':hidden',
            highlight: function (element) {
                $(element).closest('.help-block').removeClass('valid');
                // display OK icon
                $(element).closest('.form-group').removeClass('has-success').addClass('has-error').find('.symbol').removeClass('ok').addClass('required');
                // add the Bootstrap error class to the control group
            },
            unhighlight: function (element) { // revert the change done by hightlight
                $(element).closest('.form-group').removeClass('has-error');
                // set error class to the control group
            },
            success: function (label, element) {
                label.addClass('help-block valid');
                // mark the current input as valid and display OK icon
                $(element).closest('.form-group').removeClass('has-error');
            },
            highlight: function (element) {
                $(element).closest('.help-block').removeClass('valid');
                // display OK icon
                $(element).closest('.form-group').addClass('has-error');
                // add the Bootstrap error class to the control group
            },
            unhighlight: function (element) { // revert the change done by hightlight
                $(element).closest('.form-group').removeClass('has-error');
                // set error class to the control group
            }
        });
    };
    var runRegisterValidator = function () {
        var form3 = $('.form-login');
        var errorHandler3 = $('.errorHandler', form3);
        form3.validate({
            rules: {
                fullName: {
                    minlength: 2,
                    required: true
                },
                address1: {
                    minlength: 2,
                    required: true
                },
                city: {
                    minlength: 2,
                    required: true
                },
                phone: {
                    required: true
                },
                email: {
                    required: true,
                    email: true
                },
                stateId: {
                    required: true
                },
                schoolName: {
                    minlength: 2,
                    required: true
                },
                schoolType: {
                    required: true
                },
                username: {
                    minlength: 2,
                    required: true
                },
                nricNo: {
                    required: true,
                    nricNo: true
                },
                password: {
                    minlength: 6,
                    required: true
                },
                passwordAgain: {
                    required: true,
                    minlength: 5,
                    equalTo: "#password"
                }
            },
            submitHandler: function (form) {
                errorHandler3.hide();
                form.submit();
            },
            invalidHandler: function (event, validator) { //display error alert on form submit
                errorHandler3.show();
            }
        });
    };
    return {
        //main function to initiate template pages
        init: function () {
            runSetDefaultValidation();
            runRegisterValidator();
        }
    };
}();