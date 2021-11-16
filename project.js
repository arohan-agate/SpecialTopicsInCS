var userInput = {
	age: 20,
	height: 72,
	weight: 150,
	weightGoal: 
	gender: "Male",
	currExercie: 2
}

function BMI_Calc() {
	hMeters = userInput.height/39.3701
	wKilo = userInput.weight/2.205 
	return wKilo/(hMeters*hMeters)
}

function idealWeight() {
	return 22 * 
}

function WorkoutPlan() {
	var status
	BMI = BMI_Calc
	switch (BMI) {
		case BMI <= 18.5:
			status = 'U'
			break
		case BMI > 18.5 && BMI <= 24.9:
			status = 'N'
			break
		case BMI > 24.9 && BMI < 30:
			status = 'Ov'
			break
		case BMI >= 30:
			status = 'Ob'
			break
	}
}
