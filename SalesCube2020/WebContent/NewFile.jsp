<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<%

	
	class Bean{
		public int cat1;
		public int cat2;
		public int cat3;
		public String catName;	
	}

	List<Bean> list = new ArrayList<Bean>();

	Bean b1 = new Bean();
	b1.cat1 = 1;
	b1.cat2 = 1;
	b1.cat3 = 1;
	b1.catName = "test111";
	list.add(b1);
	
	Bean b2 = new Bean();
	b2.cat1 = 1;
	b2.cat2 = 1;
	b2.cat3 = 2;
	b2.catName = "test112";
	list.add(b2);
	
	Bean b3 = new Bean();
	b3.cat1 = 1;
	b3.cat2 = 2;
	b3.cat3 = 1;
	b3.catName = "test121";
	list.add(b3);
	
	Bean b4 = new Bean();
	b4.cat1 = 1;
	b4.cat2 = 2;
	b4.cat3 = 2;
	b4.catName = "test122";
	list.add(b4);
	
	Bean b5 = new Bean();
	b5.cat1 = 2;
	b5.cat2 = 1;
	b5.cat3 = 1;
	b5.catName = "test211";
	list.add(b5);
	
	request.setAttribute("test", list);

%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<button onclick="test();"></button>
<script>
	function test (){
	var mylist = [];
	var loop=0;
	
	<% for(int i=0; i<list.size(); i++){ %>
	  mylist[loop] = {
			    cat1:"<%= list.get(i).cat1 %>",
			    cat2:"<%= list.get(i).cat2 %>",
			    cat3:"<%= list.get(i).cat3 %>",
			    catName:"<%= list.get(i).catName %>",	
			  };
	  		loop++;
	<% } %>

	for(i=0; i< mylist.length; i++){
		  alert("catName: " + mylist[i].catName );
		}
	}	  
</script>
</body>
</html>