var FormValidator = function () {

    var submit_btn = $('button[type="submit"]');

    var runValidator1 = function () {
        var form1 = $('#form');
        var errorHandler1 = $('.errorHandler', form1);
        var successHandler1 = $('.successHandler', form1);
        $.validator.addMethod('nricNo', function (value) {
                return /^\d{12}$/.test(value);
            },
            'Please enter a valid NRIC no. wtihout dash. eg: 671218045678');
        $.validator.addMethod("FullDate", function () {
            //if all values are selected
            if ($("#dob_dd").val() != "" && $("#dob_mm").val() != "" && $("#dob_yyyy").val() != "") {
                return true;
            } else {
                return false;
            }
        }, 'Please select a day, month, and year');
        form1.validate({
            errorElement: "span", // contain the error msg in a span tag
            errorClass: 'help-block',
            errorPlacement: function (error, element) { // render error placement for each input type
                if (element.attr("type") == "radio" || element.attr("type") == "checkbox") { // for chosen elements, need to insert the error after the chosen container
                    error.insertAfter($(element).closest('.form-group').children('div').children().last());
                } else if (element.attr("name") == "dob_dd" || element.attr("name") == "dob_mm" || element.attr("name") == "dob_yyyy") {
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
                nricNo: {
                    minlength: 12,
                    required: true,
                    nricNo: true,
                    remote: {
                        url: "../../register/validate/",
                        type: "GET",
                        dataType: "json",
                        data: {
                            nricNo: function () {
                                return $("#nricNo").val();
                            }
                        },
                        dataFilter: function (response) {
                            return response != 'true';
                        },
                        beforeSend: function () {
                            submit_btn.attr('disabled', 'disabled');
                            submit_btn.text("Please wait..");
                        },
                        complete: function () {
                            submit_btn.removeAttr('disabled');
                            submit_btn.html("Submit <i class=\"icon-circle-arrow-right\"></i>");
                        }
                    }
                },
                username: {
                    minlength: 2,
                    required: true
                },
                dob_yyyy: "FullDate"
            },
            messages: {
                name: "Please specify your first name",
                nricNo: {
                    remote: "ID is already taken"
                }
            },
            groups: {
                DateofBirth: "dd mm yyyy"
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
            },
            submitHandler: function (form) {
                errorHandler1.hide();
                form.submit();
            },
            invalidHandler: function (event, validator) { //display error alert on form submit
                errorHandler1.show();
            }
        });
    };
    var runValidator2 = function () {
        var form1 = $('#form_student_edit');
        var errorHandler1 = $('.errorHandler', form1);
        var successHandler1 = $('.successHandler', form1);
        $.validator.addMethod('nricNo', function (value) {
                return /^\d{12}$/.test(value);
            },
            'Please enter a valid NRIC no. wtihout dash. eg: 671218045678');
        $.validator.addMethod("FullDate", function () {
            //if all values are selected
            if ($("#dob_dd").val() != "" && $("#dob_mm").val() != "" && $("#dob_yyyy").val() != "") {
                return true;
            } else {
                return false;
            }
        }, 'Please select a day, month, and year');
        form1.validate({
            errorElement: "span", // contain the error msg in a span tag
            errorClass: 'help-block',
            errorPlacement: function (error, element) { // render error placement for each input type
                if (element.attr("type") == "radio" || element.attr("type") == "checkbox") { // for chosen elements, need to insert the error after the chosen container
                    error.insertAfter($(element).closest('.form-group').children('div').children().last());
                } else if (element.attr("name") == "dob_dd" || element.attr("name") == "dob_mm" || element.attr("name") == "dob_yyyy") {
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
                nricNo: {
                    minlength: 12,
                    required: true,
                    nricNo: true
                },
                username: {
                    minlength: 2,
                    required: true
                },
                dob_yyyy: "FullDate"
            },
            messages: {
                name: "Please specify your first name",
                nricNo: {
                    remote: "ID is already taken"
                }
            },
            groups: {
                DateofBirth: "dd mm yyyy"
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
            },
            submitHandler: function (form) {
                errorHandler1.hide();
                form.submit();
            },
            invalidHandler: function (event, validator) { //display error alert on form submit
                errorHandler1.show();
            }
        });
    };
    return {
        //main function to initiate template pages
        init: function () {
            runValidator1();
            runValidator2();
        }
    };
}();