<%@page contentType="java" pageEncoding="UTF-8"%>
<html>
	<head>
		<title>Online Compiler</title>
		<link rel=stylesheet href="MyStyle.css">
	</head>
 
<body>
<form method="POST" action="NewServlet"> 
	<main>
	
	<div id="code">
	
		<div>
		<textarea id="codeArea" name="codeArea" placeholder="Enter Your Code"><% String an=(String)request.getAttribute("code"); if(an!=null)out.print(an);%></textarea>
		<input type="submit" id="runButton" value="Run"> 
		
		<select name="language" style="min-height: 40px; min-width: 100px;font-size: 25px;">
                <option value="c/cpp">C/C++</option>
                <option value="java">Java</option>
                <option value="python">Python</option>
        </select>
		
		<input type="checkbox" id="custom" name="custom" value="yes">
		<label for="custom" style="font-size:25px;">Custom Input</label><br>
		</div>
	</div>
	
	<div id="result">
		<div>
		<textarea id="inputArea" name="inputArea" placeholder="Custom Input"><% String a=(String)request.getAttribute("input"); if(a!=null)out.print(a);%></textarea>
		</div>
		<div>
		<textarea disabled class="textarea" id="resultArea" placeholder="See Result"><% String ans=(String)request.getAttribute("res"); if(ans!=null)out.print(ans);%></textarea>
		</div>
	</div>
	</main>
	</form>
        <script>
            if(document.getElementById("language").value=="java"){
                document.getElementById("resultArea").innerHTML="class Main{\npublic static void main(String[]args){\n//your code here\n}\n}";
            }
                    
        </script>
</body>