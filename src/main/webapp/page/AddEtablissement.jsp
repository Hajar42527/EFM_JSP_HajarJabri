<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" href="../css/form.css">
<title>Responsive Regisration Form</title>
</head>
<body>
	<div class="container">
		<header>Add Etablissemnt</header>
		<form action="/Etablissement-EFM/do/add" method="post">
			<div class="form first">
				<div class="details personal">
					<div class="fields">
						<div class="input-field">
							<label>Nom établissement</label> <input type="text"
								placeholder="Enter nom" name="nom" required>
						</div>

						<div class="input-field">
							<label>Adresse établissement</label> <input type="text"
								placeholder="Enter adresse" name="adress" required>
						</div>
						<div class="input-field">
							<label>Telepnone</label> <input type="text"
								placeholder="Enter Telepnone" name="tele" required>
						</div>
					</div>
				</div>

					<div class="buttons">
						<a href="../index.jsp" class="backBtn"> <span
							class="btnText">Annuler</span>
						</a>

						<button class="sumbit" type="submit">
							<span class="btnText">Submit</span>
						</button>
					</div>
			</div>

		</form>
	</div>

	<script>
    const form = document.querySelector("form"),
    nextBtn = form.querySelector(".nextBtn"),
    backBtn = form.querySelector(".backBtn"),
    allInput = form.querySelectorAll(".first input");


nextBtn.addEventListener("click", ()=> {
allInput.forEach(input => {
    if(input.value != ""){
        form.classList.add('secActive');
    }else{
        form.classList.remove('secActive');
    }
})
})

backBtn.addEventListener("click", () => form.classList.remove('secActive'));
    </script>
</body>
</html>