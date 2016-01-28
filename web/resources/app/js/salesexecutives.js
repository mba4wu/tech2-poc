/**
 * Created by mburns on 1/21/16.
 */

$.extend($.jgrid.defaults, {
    ajaxGridOptions: { contentType: "application/json;charset=UTF-8", reloadAfterSubmit : true },
    ajaxRowOptions: { contentType: "application/json;charset=UTF-8", async: true },
    ajaxSelectOptions: { contentType: "application/json;charset=UTF-8", dataType: "JSON" }
});
$.extend($.jgrid.edit, {
    ajaxEditOptions: { contentType: "application/json;charset=UTF-8" },
    afterSubmit: function () {
        $(this).jqGrid("setGridParam", {datatype: 'json'});
        return [true];
    },
    recreateForm: true,
    closeAfterEdit : true,
    closeAfterAdd : true,
    reloadAfterSubmit : true,
    serializeEditData: function(postData) {
        delete postData['oper'];
        //delete postData['id'];
        return JSON.stringify(postData);
    }

});

jQuery(document).ready(function () {
    $("#list").jqGrid({
        url: "http://localhost:8080/salesPerson/all/sorted",
        datatype: 'json',
        colNames: ['FirstName', 'LastName', 'Email', 'Phone', 'Mobile', 'Active','Id'],
        colModel: [{
            name: 'firstName',
            index: 'firstName',
            width: 150,
            editable: true
        }, {
            name: 'lastName',
            index: 'lastName',
            width: 150,
            editable: true
        }, {
            name: 'email',
            index: 'email',
            width: 150,
            editable: true
        }, {
            name: 'phone',
            index: 'phone',
            width: 150,
            editable: true
        }, {
            name: 'cellPhone',
            index: 'cellPhone',
            width: 150,
            editable: true
        }, {
            name: 'isActive',
            index: 'isActive',
            width: 150,
            editable: true
        },
            {
                name: 'id',
                index: 'id',
                width: 150,
                editable: true,
                hidden : true
            }
        ],
        rowNum: 20,
        pager: '#pager',
        cmTemplate: {autoResizable: true, editable: true},
        iconSet: "fontAwesome",
        autoResizing: {compact: true},
        rowList: [20, 30, 40, "10000:All"],
        viewrecords: true,
        sortable: true,
        loadonce: true,
        sortname: "firstName",
        contentType: "application/json; charset=utf-8",
        jsonReader: {
            repeatitems: false,
        }
    }).trigger("reloadGrid");

    $('#list').jqGrid('navGrid', '#pager',
        {
            edit: true,
            add: true,
            del: true,
            search: true,
            refresh : true,
            searchtext: "Search",
            addtext: "Add",
            edittext: "Edit",
            deltext: "Delete",
            reloadGridOptions: { fromServer: true, page: 1}

        },
    //edit options
    { url: 'http://localhost:8080/salesPerson/new', closeAfterEdit: true, reloadAfterSubmit : true},
    //add options
    { url: 'http://localhost:8080/salesPerson/new',  closeAfterAdd : true, reloadAfterSubmit : true}
    );

    $("#list").trigger("reloadGrid", { fromServer: true, page: 1 });

    $("#list").setGridParam({sortname:'firstName', sortorder:'asc',datatype:'json'}).trigger('reloadGrid', {fromServer: true, page: 1});


});

