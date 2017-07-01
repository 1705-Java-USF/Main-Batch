/**
 * 
 */

function toggledisplay(elementID)
    {
        (function(style) {
            style.display = style.display === 'block' ? 'none' : 'block';
        })(document.getElementById(elementID).style);

		console.log("test");
    }