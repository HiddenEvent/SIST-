<%@ page session="false" pageEncoding="UTF-8" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<br /><br /><br />
	<div style="padding-left:20px">
		<h2>Spring MVC Custom View Demo</h2>
		
		<h3>1-1. <a href="simplecustomview1.action">Simple Custom View 1</a></h3>
		<h3>1-2. <a href="simplecustomview2.action">Simple Custom View 2</a></h3>
		<h3>2. <a href="pdfview.action">PDF View</a></h3>
		<h3>3. <a href="excelview.action">Excel View</a></h3>
		<h3>4. File Upload</h3>
		<form action="upload.action"
			method="post" enctype="multipart/form-data">
			<input type="file" name="files" /><br />		
			<input type="text" name="data" /><br />
			<input type="submit" value="전송" />
		</form>
		<h3>5. <a href="download.action">File Download</a></h3>
	</div>
</body>
</html>











