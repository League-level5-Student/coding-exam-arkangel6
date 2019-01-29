package Coding_Exam_A;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class CodingExamA {
	public static void main(String[] args) {
		/*
		 * Write a program that asks the user for three pieces of information. 1. How
		 * many robots 2. The color of the shapes 3. How many sides each shape will have
		 * 
		 * Once the information has been collected, the program will then make the
		 * requested number of robots each draw the requested shape in the requested
		 * color. The robots should execute at the same time so Threads will need to be
		 * used. Arrange the robots so that the shapes do not overlap. For full credit,
		 * define the Thread functions using lambdas.
		 * 
		 * See the Coding_Exam_A_Demo.jar for an example of what the finished product
		 * should look like.
		 */

		String robotNum = JOptionPane.showInputDialog("how many robots?");
		int robNum = Integer.parseInt(robotNum);

		String color = JOptionPane.showInputDialog("what color are the shapes?");
		HashMap<String, Color> c = new HashMap<String, Color>();
		c.put("blue", Color.blue);
		c.put("red", Color.red);
		c.put("green", Color.green);
		c.put("yellow", Color.yellow);
		c.put("pink", Color.pink);
		c.put("orange", Color.orange);
		c.put("magenta", Color.magenta);

		Color c2 = c.get(0);
		for (int i = 0; i < c.size(); i++) {
			if (c.containsKey(color)) {
				c2 = c.get(color);
			}
		}

		String sides = JOptionPane.showInputDialog("how many sides are the shapes?");
		int sideNum = Integer.parseInt(sides);
		int angle = 180 * (sideNum - 2) / sideNum;

		System.out.println(angle);

		ArrayList<Robot> robList = new ArrayList<Robot>();
		int x = 0;
		for (int i = 0; i < robNum; i++) {
			Robot r = new Robot(200 + x, 200);
			r.setSpeed(10);
			r.penDown();
			r.setPenColor(c2);
			robList.add(r);
			x += 200;
		}

		for (int i = 0; i < robNum; i++) {

			Robot k = robList.get(i);
			Thread t1 = new Thread(() -> {
				for (int j = 0; j < sideNum; j++) {
					k.move(150);
					k.turn(180 - angle);
				}

			});

			t1.start();
		}

	}
}
