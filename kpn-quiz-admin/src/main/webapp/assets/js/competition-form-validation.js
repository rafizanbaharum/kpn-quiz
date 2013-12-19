var FormValidator = function () {
    // function to initiate Validation Sample 1
    var runValidator1 = function () {
        var form1 = $('#form');
        var errorHandler1 = $('.errorHandler', form1);
        var successHandler1 = $('.successHandler', form1);
        $.validator.addMethod("StartFullDate", function () {
            //if all values are selected
            if ($("#startDate_dd").val() != "" && $("#startDate_MM").val() != "" && $("#startDate_yyyy").val() != "") {
                return true;
            } else {
                return false;
            }
        }, 'Please select a day, month, and year');
        $.validator.addMethod("EndFullDate", function () {
            //if all values are selected
            if ($("#endDate_dd").val() != "" && $("#endDate_MM").val() != "" && $("#endDate_yyyy").val() != "") {
                return true;
            } else {
                return false;
            }
        }, 'Please select a day, month, and year');
        $.validator.addMethod("greaterThan",
            function (value, element, params) {

                if (!/Invalid|NaN/.test(new Date(value))) {
                    return new Date(value) > new Date($(params).val());
                }

                return isNaN(value) && isNaN($(params).val())
                    || (Number(value) > Number($(params).val()));
            }, 'Must be greater than {0}.');
        form1.validate({
            errorElement: "span", // contain the error msg in a span tag
            errorClass: 'help-block',
            errorPlacement: function (error, element) { // render error placement for each input type
                if (element.attr("type") == "radio" || element.attr("type") == "checkbox") { // for chosen elements, need to insert the error after the chosen container
                    error.insertAfter($(element).closest('.form-group').children('div').children().last());
                } else if (element.attr("name") == "startDate_dd" || element.attr("name") == "startDate_MM" || element.attr("name") == "startDate_yyyy") {
                    error.insertAfter($(element).closest('.form-group').children('div'));
                } else if (element.attr("name") == "endDate_dd" || element.attr("name") == "endDate_MM" || element.attr("name") == "endDate_yyyy") {
                    error.insertAfter($(element).closest('.form-group').children('div'));
                } else {
                    error.insertAfter(element);
                    // for other inputs, just perform default behavior
                }
            },
            ignore: "",
            rules: {
                name: {
                    minlength: 2,
                    required: true
                },
                nric: {
                    minlength: 2,
                    required: true
                },
                username: {
                    minlength: 2,
                    required: true
                },
                password: {
                    minlength: 6,
                    maxlength: 8,
                    required: true
                },
                passwordAgain: {
                    required: true,
                    minlength: 5,
                    equalTo: "#password"
                },
                startDate_yyyy: "StartFullDate",
                endDate_yyyy: "EndFullDate"
            },
            messages: {
                name: "Please specify your first name"
            },
            groups: {
                DateofBirth: "dd mm yyyy"
            },
            invalidHandler: function (event, validator) { //display error alert on form submit
                successHandler1.hide();
                errorHandler1.show();
            },
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
                $(element).closest('.form-group').removeClass('has-error').addClass('has-success').find('.symbol').removeClass('required').addClass('ok');
            }
            /*
             submitHandler: function (form) {
             successHandler1.show();
             errorHandler1.hide();
             }
             */
        });
    };
    return {
        //main function to initiate template pages
        init: function () {
            runValidator1();
        }
    };
}();