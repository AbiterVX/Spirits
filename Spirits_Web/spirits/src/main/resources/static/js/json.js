
function serializeFormToJSON(form_id) {
    formObject = {};
    x = form_id.serializeArray();
    $.each(x, function (i, field) {
        formObject[field.name] = field.value;
    });
    return formObject;
}