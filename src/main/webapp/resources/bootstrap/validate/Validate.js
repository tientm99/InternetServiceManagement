$(document).ready(function() {
    $('#phone').on('input', function(event) {
        event.preventDefault(); 
        // Lấy giá trị của input
        var phoneNumber = $(this).val();
        // Biểu thức chính quy để kiểm tra
        var phoneRegex = /^(?:\+?(84)|0)(90|91)\d{7}$/;
        // Kiểm tra xem giá trị nhập vào có phù hợp với định dạng không
        if (phoneRegex.test(phoneNumber)) {
            // Nếu hợp lệ, loại bỏ class 'is-invalid' (nếu có) và thêm class 'is-valid'
            $(this).removeClass('is-invalid').addClass('is-valid');
        } else {
            // Nếu không hợp lệ, loại bỏ class 'is-valid' (nếu có) và thêm class 'is-invalid'
            $(this).removeClass('is-valid').addClass('is-invalid');
        }
    });
});


$(document).ready(function() {
    $('#email').on('input', function(event) {
        event.preventDefault(); 
        // Lấy giá trị của input
        var phoneNumber = $(this).val();
        // Biểu thức chính quy để kiểm tra
        var phoneRegex = /^[a-zA-Z0-9]+@gmail\.com/;
        // Kiểm tra xem giá trị nhập vào có phù hợp với định dạng không
        if (phoneRegex.test(phoneNumber)) {
            // Nếu hợp lệ, loại bỏ class 'is-invalid' (nếu có) và thêm class 'is-valid'
            $(this).removeClass('is-invalid').addClass('is-valid');
        } else {
            // Nếu không hợp lệ, loại bỏ class 'is-valid' (nếu có) và thêm class 'is-invalid'
            $(this).removeClass('is-valid').addClass('is-invalid');
        }
    });
});

$(document).ready(function() {
    $('#quantity, #duration, #price').on('input', function() {
        // Lấy giá trị của input
        var value = $(this).val();
        // Chuyển đổi giá trị sang số nguyên
        var intValue = parseInt(value);

        var regex = /^[1-9]\d{0,20}$/;
        // Kiểm tra xem giá trị có phải là số nguyên dương không
        if (regex.test(value)) {
            // Nếu là số nguyên dương, loại bỏ class 'is-invalid' (nếu có) và thêm class 'is-valid'
            $(this).removeClass('is-invalid').addClass('is-valid');
        } else {
            // Nếu không phải là số nguyên dương, loại bỏ class 'is-valid' (nếu có) và thêm class 'is-invalid'
            $(this).removeClass('is-valid').addClass('is-invalid');
        }
    });
});

