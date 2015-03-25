package boundary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

import entity.WeightData;

public class TUI {
	WeightData vaegtdata;
	private BufferedReader inFromUser = new BufferedReader(
			new InputStreamReader(System.in));

	public TUI(WeightData vaegtdata) {
		this.vaegtdata = vaegtdata;
		vaegtdata.setInstruktionsdisplay1("");
		vaegtdata.setBrutto(0);
		vaegtdata.setRm20_kommando("");
		vaegtdata.setInstruktionsdisplay2("");
	}
	public void closeTUI(){
		try {
			inFromUser.close();
			System.in.close();
			System.out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public TUI() {
	}

	public void printMessage(String message) {
		System.out.println(message);
	}

	public String getResponse() throws IOException {
		return inFromUser.readLine();
	}

	public void print_Menu(WeightData vaegtdata) {
		this.vaegtdata = vaegtdata;
		System.out.println(" ");
		System.out.println("*************************************************");
		if (this.vaegtdata.getRm20_kommando() != "") {
			System.out.println("Instruktion: "
					+ this.vaegtdata.getRm20_kommando());
		}
		if (this.vaegtdata.getInstruktionsdisplay1() == "") {
			System.out.println("Netto: " + (this.vaegtdata.getNetto()) + " kg");
		} else if (this.vaegtdata.getInstruktionsdisplay1() != "") {
			System.out.println("Instruktionsdisplay: "
					+ this.vaegtdata.getInstruktionsdisplay1());
		}
		if (this.vaegtdata.getInstruktionsdisplay2() != "") {
			System.out.println("Sekundærtdisplay: "
					+ this.vaegtdata.getInstruktionsdisplay2());
		}
		System.out.println("*************************************************");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Debug info: ");
		System.out
				.println("Hooked up to " + this.vaegtdata.getConnected_host());
		System.out.println("Brutto: " + (this.vaegtdata.getBrutto()) + " kg");
		System.out.println("Streng modtaget: "
				+ this.vaegtdata.getStreng_fra_bruger());
		System.out.println(" ");
		System.out.println("Denne vægt simulator lytter på ordrene ");
		System.out.println("D, DN, S, T, B, Q ");
		System.out.println("på kommunikationsporten. ");
		System.out.println("******");
		System.out.println("Tast T for tara (svarende til knaptryk paa vægt)");
		System.out
				.println("Tast B for ny brutto (svarende til at belastningen på vægt ændres)");
		System.out.println("Tast Q for at afslutte program program");
		System.out
				.println("Indtast (T/B/Q for knaptryk / brutto ændring / quit)");
		if (this.vaegtdata.getRm20_kommando() != "") {
			System.out.println("Tast S for at svare på RM20 kommando");
			System.out.print("Tast her: ");
		} else {
			System.out.print("Tast her: ");
		}

	}

}