var $ = jQuery.noConflict();
$(document).ready(function () {
	"use strict";
	scrollUpBinding();
});

function scrollUpBinding(){
	"use strict";
	$('.scrollup').on('click', function(e){
        $("html, body").animate({ scrollTop: 0 }, 600);
        return false;
    });
}