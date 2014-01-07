var Login = function () {

    var submit_btn = $('button[type="submit"]');

    $.validator.addMethod('nricNo', function (value) {
            return /^\d{12}$/.test(value);
        },
        'Please enter a valid NRIC No. without dash. eg: 671218045678');

    $.validator.addMethod('validatePhoneAndFax', function (value) {
            return /^\+?\d*$/.test(value);
        },
        'Please enter a valid phone no. eg: +6031234567');

    var runLoginButtons = function () {
        $('.forgot').bind('click', function () {
            $('.box-login').hide();
            $('.box-forgot').show();
        });
        $('.register').bind('click', function () {
            $('.box-login').hide();
            $('.box-register').show();
        });
        $('.go-back').click(function () {
            $('.box-login').show();
            $('.box-forgot').hide();
            $('.box-register').hide();
        });
    };
    var runSetDefaultValidation = function () {

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
            }
        });
    };
    var runLoginValidator = function () {
        var form = $('.form-login');
        var errorHandler = $('.errorHandler', form);
        form.validate({
            rules: {
                username: {
                    minlength: 12,
                    required: true,
                    nricNo: true
                },
                password: {
                    minlength: 6,
                    maxlength: 8,
                    required: true
                }
            },
            submitHandler: function (form) {
                errorHandler.hide();
                form.submit();
            },
            invalidHandler: function (event, validator) { //display error alert on form submit
                errorHandler.show();
            }
        });
    };
    var runForgotValidator = function () {
        var form2 = $('.form-forgot');
        var errorHandler2 = $('.errorHandler', form2);
        form2.validate({
            rules: {
                nricNo: {
                    minlength: 12,
                    maxlength: 12,
                    required: true,
                    nricNo: true,
                    remote: {
                        url: getContextRoot() + "/register/validate/",
                        type: "GET",
                        dataType: "json",
                        data: {
                            nricNo: function () {
                                return $("#nricNo").val();
                            }
                        },
                        dataFilter: function (response) {
                            return response == 'true';
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
                }
            },
            messages: {
                nricNo: {remote: "Invalid ID"}
            },
            submitHandler: function (form) {
                errorHandler2.hide();
                form.submit();
            },
            invalidHandler: function (event, validator) { //display error alert on form submit
                errorHandler2.show();
            }
        });
    };
    var runRegisterValidator = function () {
        var form3 = $('.form-register');
        var errorHandler3 = $('.errorHandler', form3);
        form3.validate({
            rules: {
                fullName: {
                    minlength: 5,
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
                    required: true,
                    validatePhoneAndFax: true
                },
                fax: {
                    required: true,
                    validatePhoneAndFax: true
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
                schoolPhone: {
                    required: true,
                    validatePhoneAndFax: true
                },
                schoolFax: {
                    required: true,
                    validatePhoneAndFax: true
                },
                schoolType: {
                    required: true
                },
                username: {
                    minlength: 12,
                    maxlength: 12,
                    required: true
                },
                nricNo: {
                    minlength: 12,
                    required: true,
                    nricNo: true,
                    remote: {
                        url: getContextRoot() + "/register/validate/",
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
                password: {
                    minlength: 6,
                    maxlength: 8,
                    required: true
                },
                passwordAgain: {
                    required: true,
                    minlength: 6,
                    equalTo: "#password"
                }
            },
            messages: {
                nricNo: {
                    remote: "ID is already registered"
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
            runLoginButtons();
            runSetDefaultValidation();
            runLoginValidator();
            runForgotValidator();
            runRegisterValidator();
        }
    };
}();