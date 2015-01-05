$(document).ready(function () {
    if ($(".bottomControls").length > 0) {
        var form = $(".bottomControls");
        var pos = form.offset().top;
        $(window).scroll(function () {
            if ($(window).scrollTop() + $(window).height() -  form.outerHeight() < pos) {
                form.addClass("sticky");
            }
            else {
                form.removeClass("sticky");
            }
        });
    }
});