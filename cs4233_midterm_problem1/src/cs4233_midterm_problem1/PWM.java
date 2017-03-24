package cs4233_midterm_problem1;

import java.util.ArrayList;

public class PWM {

	private int amount;
	private int length;
	private ArrayList<String> align;
	private float pwm[][];
	private float pfm[][];
	private float ppm[][];
	private float info[];
	
	PWM(ArrayList<String> alignment){
		align = alignment;
		amount = align.size();
		length = align.get(0).length();
		
		setPwm(new float[4][length]);
		setPfm(new float[4][length]);
		setPpm(new float[4][length]);
		setInfo(new float[length]);
		createPFM();
		printPFM();
		calculatePPM();
		printPPM();
		calculatePWM();
		printPWM();
		calculateH();
		calculateI();
		
	}

	private void calculateH() {
		System.out.print("\n\nH\t");
		for(int i = 0; i < length; i++) {
			for(int c = 0; c < 4; c++) {
				info[i] += -ppm[c][i]*(Math.log10((ppm[c][i])) / Math.log10(2));
			}
			System.out.printf("%.3f\t",info[i]);
		}
	}

	private void calculateI() {
		System.out.print("\nI\t");
		for(int i = 0;i < length; i++) {
			System.out.printf("%.3f\t", 2 - info[i]);
		}
		
	}

	private void calculatePWM() {
		for(int i = 0; i < 4; i++) {
			for(int c = 0; c < length; c++) {
				pwm[i][c] = (float) (Math.log10((ppm[i][c]/ .25)) / Math.log10(2));
			}
		}
	}

	private void calculatePPM() {
		for(int i = 0; i < 4; i++) {
			for(int c = 0; c < length; c++) {
				ppm[i][c] = (pfm[i][c] + 1) / (amount + 4);
			}
		}
	}

	private void printPWM() {
		int i;
		System.out.print("\nPWM\n");
		System.out.print("A\t");
		for(i = 0; i < length; i++) {
			System.out.printf("%.3f", pwm[0][i]);
			System.out.print("\t");
		}
		System.out.print("\nC\t");
		for(i = 0; i < length; i++) {
			System.out.printf("%.3f", pwm[1][i]);
			System.out.print("\t");
		}
		System.out.print("\nG\t");
		for(i = 0; i < length; i++) {
			System.out.printf("%.3f", pwm[2][i]);
			System.out.print("\t");
		}
		System.out.print("\nT\t");
		for(i = 0; i < length; i++) {
			System.out.printf("%.3f", pwm[3][i]);
			System.out.print("\t");
		}
	}

	private void printPFM() {
		int i;
		System.out.println("\nPFM");
		System.out.print("A\t");
		for(i = 0; i < length; i++) {
			System.out.printf("%.2f", pfm[0][i]);
			System.out.print("\t");
		}
		System.out.print("\nC\t");
		for(i = 0; i < length; i++) {
			System.out.printf("%.2f", pfm[1][i]);
			System.out.print("\t");
		}
		System.out.print("\nG\t");
		for(i = 0; i < length; i++) {
			System.out.printf("%.2f", pfm[2][i]);
			System.out.print("\t");
		}
		System.out.print("\nT\t");
		for(i = 0; i < length; i++) {
			System.out.printf("%.2f", pfm[3][i]);
			System.out.print("\t");
		}
	}
	
	private void printPPM() {
		int i;
		System.out.print("\nPPM\n");
		System.out.print("A\t");
		for(i = 0; i < length; i++) {
			System.out.printf("%.3f", ppm[0][i]);
			System.out.print("\t");
		}
		System.out.print("\nC\t");
		for(i = 0; i < length; i++) {
			System.out.printf("%.3f", ppm[1][i]);
			System.out.print("\t");
		}
		System.out.print("\nG\t");
		for(i = 0; i < length; i++) {
			System.out.printf("%.3f", ppm[2][i]);
			System.out.print("\t");
		}
		System.out.print("\nT\t");
		for(i = 0; i < length; i++) {
			System.out.printf("%.3f", ppm[3][i]);
			System.out.print("\t");
		}
	}
	private void createPFM() {
		for(int i = 0; i < amount; i++) {
			for(int c = 0; c < length; c++) {
				switch(align.get(i).charAt(c)) {
				case 'A':
					pfm[0][c] += 1;
					break;
				case 'C':
					pfm[1][c] += 1;
					break;
				case 'G':
					pfm[2][c] += 1;
					break;
				case 'T':
					pfm[3][c] += 1;
					break;
				}
			}
		}
	}

	public float[][] getPwm() {
		return pwm;
	}

	public void setPwm(float pwm[][]) {
		this.pwm = pwm;
	}

	public float[][] getPfm() {
		return pfm;
	}

	public void setPfm(float pfm[][]) {
		this.pfm = pfm;
	}

	public float[][] getPpm() {
		return ppm;
	}

	public void setPpm(float ppm[][]) {
		this.ppm = ppm;
	}

	public float[] getInfo() {
		return info;
	}

	public void setInfo(float info[]) {
		this.info = info;
	}
}
