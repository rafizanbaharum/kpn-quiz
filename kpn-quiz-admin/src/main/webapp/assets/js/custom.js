jQuery(document).ready(function () {

    // highlight menu
    var str = location.href.toLowerCase();
    jQuery('ul.sub-menu li a').each(function () {
        if (str.indexOf(this.href.toLowerCase()) > -1) {
            jQuery("li.active").removeClass("active");
            jQuery(this).parent().addClass("active");
        }
    });
    jQuery('li.active').parents().each(function () {
        if (jQuery(this).is("li")) {
            jQuery(this).addClass("active").addClass("open");
        } else if (jQuery(this).is("ul")) {
            jQuery(this).css("display", "block");
        }
    });

});
