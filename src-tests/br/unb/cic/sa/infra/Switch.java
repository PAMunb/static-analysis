package br.unb.cic.sa.infra;

public class Switch {

	public Switch() {
		printColorUsingSwitch("red");
		printColorUsingSwitch("RED");
		printColorUsingSwitch(null);
	}

	private static void printColorUsingSwitch(String color) {
		switch (color) {
		case "blue":
			System.out.println("BLUE");
			break;
		case "red":
			System.out.println("RED");
			break;
		default:
			System.out.println("INVALID COLOR CODE");
		}
	}

	public String getTypeOfDayWithSwitchStatement(String dayOfWeekArg) {
		String typeOfDay;
		switch (dayOfWeekArg) {
		case "Monday":
			typeOfDay = "Start of work week";
			break;
		case "Tuesday":
		case "Wednesday":
		case "Thursday":
			typeOfDay = "Midweek";
			break;
		case "Friday":
			typeOfDay = "End of work week";
			break;
		case "Saturday":
		case "Sunday":
			typeOfDay = "Weekend";
			break;
		default:
			return null;
		}
		return typeOfDay;
	}

	public void getDiaSemana(int diaDaSemana) {

		switch (diaDaSemana) {
			case 1:
				System.out.println("Domingo");
				break;
			case 2:
				System.out.println("Segunda-feira");
				break;
			case 3:
				System.out.println("Terça-feira");
				break;
			case 4:
				System.out.println("Quarta-feira");
				break;
			case 5:
				System.out.println("Quinta-feira");
				break;
			case 6:
				System.out.println("Sexta-feira");
				break;
			case 7:
				System.out.println("Sábado");
				break;
			default:
				System.out.println("Este não é um dia válido!");
		}

	}
}
