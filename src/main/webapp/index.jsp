<html>
<body>
    <h2>Test Book REST Api</h2>
    <p><a href="webapi/book">Return all book (webapi/book)</a>
    <p><a href="webapi/book/1">Return fitst book ("webapi/book/1)</a>
    <p><form action="webapi/book/" method="get">
        ID:<br>
        <input type="text" name="ID" value="1">
        <input type="submit" class="btn btn-success" value="Send GET request">
    </form>
    <p><form action="webapi/book/" method="post">
        ID:<br>
        <input type="text" name="ID" value="10"><br>
        Name:<br>
        <input type="text" name="name" value="Mickey"><br>
        Auhor:<br>
        <input type="text" name="author" value="Mouse"><br>
        Year:<br>
        <input type="text" name="year" value="1940"><br>
        <br>
        <input type="submit" class="btn btn-success" value="Send POST request">
    </form>


    <h2>Jersey RESTful Web Application!</h2>
    <p><a href="webapi/test">Return text</a>
    <p><a href="webapi/book">Return book json</a>
    <p><a href="webapi/book/testname">Return book firstName=testname</a>
    <p><a href="webapi/book/add/?name=monday&author=strugatskiy&year=1960">Return book ?name=monday&author=strugatskiy&year=1960</a>


    <p><a href="webapi/book/json">Return book auto json</a>
    <p><a href="webapi/book/xml">Return book auto xml</a>
    <p><a href="webapi/book/jsonxml">Return book auto json_xml</a>


    <p><a href="webapi/MyJaxbBean/json">Return auto generated MyJaxbBean json</a>
    <p><a href="webapi/MyJaxbBean/xml">Return auto generated MyJaxbBean xml</a>

    <p>Visit <a href="http://jersey.java.net">Project Jersey website</a>




    for more information on Jersey!
    <p>New line 333
</body>
</html>
