<%--
  Created by IntelliJ IDEA.
  User: mburns
  Date: 1/21/16
  Time: 4:26 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
    <title>jqGird in Servlet</title>

    <link rel="stylesheet" href="/resources/jquery-ui/css/themes/smoothness/jquery-ui.min.css">
    <link rel="stylesheet" href="/resources/jqgrid/css/ui.jqgrid.min.css">
    <link rel="stylesheet" href="/resources/font-awesome/css/font-awesome.min.css">

    <script src="/resources/jquery/js/jquery.min.js"></script>
    <script src="/resources/jqgrid/js/jquery.jqgrid.min.js"></script>

    <script src="/resources/app/js/salesexecutives.js"></script>

<%--
    <script>
        $.jgrid = $.jgrid || {};
        $.jgrid.no_legacy_api = true;
        $.jgrid.useJSON = true;
    </script>--%>
</head>
<body>
<div align="center">
    <table id="list">
        <tr>
            <td/>
        </tr>
    </table>
    <div id="pager"></div>
</div>
</body>
</html>