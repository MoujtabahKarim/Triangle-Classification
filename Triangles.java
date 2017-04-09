import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JTextPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.JSlider;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTree;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.JToggleButton;
import javax.swing.JScrollPane;

public class Triangles {

	private JFrame frmTriangleClassification;
	private JTextField SideA;
	private JTextField SideC;
	private JTextField SideB;
	private JTextPane txtpnSideA;
	private JTextPane textPane;
	private JTextPane txtpnSideC;
	private JButton btnStart;
	private JLabel lblNewLabel;
	private JTextField SideClassify;
	private JTextField AngleClassify;
	private JLabel lblAngleClassification;
	private JLabel lblAngleX;
	private JLabel lblAngleY;
	private JTextField AngleY;
	private JLabel lblAngleZ;
	private JTextField AngleZ;
	private JTextField AngleX;
	private JLabel lblPerimeter;
	private JTextField Perim;
	private JTextField AreaBox;
	private JLabel lblArea;
	private JTextField ins;
	private JTextField Circ;
	private JLabel lblRadiusOfThe;
	private JLabel lblRadiusOfThe_1;
	private JLabel lblSemiperimeter;
	private JTextField SemiPerm;
	private JTextField txtRules;
	private JTextField txtInput;
	private JTextField txtHaveFun;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Triangles window = new Triangles();
					window.frmTriangleClassification.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Triangles() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTriangleClassification = new JFrame();
		frmTriangleClassification.getContentPane().setFont(
				new Font("Tahoma", Font.PLAIN, 10));
		frmTriangleClassification.setTitle("Moujtabah Karim");
		frmTriangleClassification.setResizable(false);
		frmTriangleClassification.setBounds(100, 100, 421, 404);
		frmTriangleClassification
				.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTriangleClassification.getContentPane().setLayout(null);

		SideA = new JTextField();
		SideA.setBounds(11, 31, 103, 22);
		frmTriangleClassification.getContentPane().add(SideA);
		SideA.setColumns(10);

		SideC = new JTextField();
		SideC.setBounds(305, 31, 95, 22);
		frmTriangleClassification.getContentPane().add(SideC);
		SideC.setColumns(10);

		SideB = new JTextField();
		SideB.setBounds(152, 31, 102, 22);
		SideB.setColumns(10);
		frmTriangleClassification.getContentPane().add(SideB);

		txtpnSideA = new JTextPane();
		txtpnSideA.setBounds(152, 11, 61, 20);
		txtpnSideA.setEnabled(false);
		txtpnSideA.setText("Side B");
		txtpnSideA.setEditable(false);
		frmTriangleClassification.getContentPane().add(txtpnSideA);

		textPane = new JTextPane();
		textPane.setBounds(11, 11, 60, 20);
		textPane.setText("Side A");
		textPane.setEnabled(false);
		textPane.setEditable(false);
		frmTriangleClassification.getContentPane().add(textPane);

		txtpnSideC = new JTextPane();
		txtpnSideC.setBounds(305, 11, 36, 20);
		txtpnSideC.setText("Side C");
		txtpnSideC.setEnabled(false);
		txtpnSideC.setEditable(false);
		frmTriangleClassification.getContentPane().add(txtpnSideC);

		// When User Clicks 'Calculate Triangle' ***
		btnStart = new JButton("Calculate Triangle");
		btnStart.setBounds(11, 64, 402, 22);
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int SideOne, SideTwo, SideThree;
				try {
					SideOne = Integer.parseInt(SideA.getText());
					SideTwo = Integer.parseInt(SideB.getText());
					SideThree = Integer.parseInt(SideC.getText());

					CheckTriangle(SideOne, SideTwo, SideThree,
							LargestNumber(SideOne, SideTwo, SideThree),
							MiddleNumber(SideOne, SideTwo, SideThree),
							SmallestNumber(SideOne, SideTwo, SideThree));

					SideClassification(SideOne, SideTwo, SideThree);
					AngleClassification(SideOne, SideTwo, SideThree);
					DisplayInformation(SideOne, SideTwo, SideThree);

				} catch (Exception e) {
					JOptionPane
							.showMessageDialog(null,
									"Please make sure ALL sides contain a integer value.");
				}

			}

			public void CheckTriangle(int SideOne, int SideTwo, int SideThree,
					int LargestSide, int MiddleSide, int SmallestSide) {

				//Check The Small, Mid, Large Number (CONSOL CODE)
				System.out.println("Small: " + SmallestSide);
				System.out.println("Mid: " + MiddleSide);
				System.out.println("Largest: " + LargestSide);
				
				
				if (SideOne == 0 && SideTwo == 0 && SideThree == 0) {

					JOptionPane.showMessageDialog(null, "deuces.");
					System.exit(0);
				}

				if (SmallestSide + MiddleSide < LargestSide || SmallestSide + MiddleSide == LargestSide) {
					JOptionPane
							.showMessageDialog(
									null,
									"Wow! You managed to make an impossible triangle, sadly this program cannot do the imposible, Please try again!");

				}
				if (SideOne < 1 || SideTwo < 1 || SideThree < 1) {

					JOptionPane
							.showMessageDialog(null,
									"Don't be silly, a triangle has to have POSITIVE sides, Please try again!");

				}

			}

			// Method used to check the Side Classification
			public String SideClassification(int SideOne, int SideTwo,
					int SideThree) {
				String TypeOfSide = null;

				if (SideOne == SideTwo && SideOne == SideThree) {
					TypeOfSide = "Equilateral";

				} else if (SideOne != SideTwo && SideOne != SideThree
						&& SideThree != SideTwo) {
					TypeOfSide = "Scalene";

				} else if ((SideOne == SideTwo && SideThree != SideOne && SideThree != SideTwo)
						|| (SideThree == SideTwo && SideOne != SideTwo && SideOne != SideThree)
						|| (SideThree == SideOne && SideTwo != SideThree && SideTwo != SideOne)) {
					TypeOfSide = "Isosceles";

				}
				SideClassify.setText(TypeOfSide);
				return TypeOfSide;

			}

			// Method used to get the largest Side
			public int LargestNumber(int SideOne, int SideTwo, int SideThree) {

				int LargestNumber = 0;

				LargestNumber = Math.max(SideOne, Math.max(SideTwo, SideThree));

				return LargestNumber;

			}

			// Method used to get the Smallest Side
			public int SmallestNumber(int SideOne, int SideTwo, int SideThree) {
				int SmallestNumber = 0;

				SmallestNumber = Math.min(SideOne, Math.max(SideTwo, SideThree));

				return SmallestNumber;

			}

			// Method used to find the middle number out of the three side

			public int MiddleNumber(int SideOne, int SideTwo, int SideThree) {
				int midNum = 0;

				if ((SideOne - SideTwo) * (SideThree - SideOne) >= 0) {

					midNum = SideOne;

				} else if ((SideTwo - SideOne) * (SideThree - SideTwo) >= 0) {
					midNum = SideTwo;
				} else {

					midNum = SideThree;
				}

				return midNum;

			}

			// Method used to check the Angle Classification
			public String AngleClassification(int SideOne, int SideTwo,
					int SideThree) {
				String TypeOfAngle = null;

				// Ordered Side Lengths Variables
				int LargestSide = LargestNumber(SideOne, SideTwo, SideThree);
				int SmallestSide = SmallestNumber(SideOne, SideTwo, SideThree);
				int MiddleSide = MiddleNumber(SideOne, SideTwo, SideThree);

				// Sides Powered By 2
				int Largest = (int) Math.pow(LargestSide, 2);
				int Smallest = (int) Math.pow(SmallestSide, 2);
				int Middle = (int) Math.pow(MiddleSide, 2);

				if (Smallest + Middle > Largest) {
					TypeOfAngle = "acute";

				} else if (Smallest + Middle < Largest) {
					TypeOfAngle = "obtuse";

				} else if (Smallest + Middle == Largest) {
					TypeOfAngle = "right";

				}

				AngleClassify.setText(TypeOfAngle);
				return TypeOfAngle;
			}

			// Method To Display The Extra Information
			public String DisplayInformation(int SideOne, int SideTwo,
					int SideThree) {

				// ********** EXTRA INFORMATION VARIABLES ********************
				// Angle Variables
				double Anglex = (Math.acos((Math.pow(SideTwo, 2)
						+ Math.pow(SideThree, 2) - Math.pow(SideOne, 2))
						/ (2 * SideTwo * SideThree)))
						* 180 / Math.PI;
				double Angley = (Math.acos((Math.pow(SideThree, 2)
						+ Math.pow(SideOne, 2) - Math.pow(SideTwo, 2))
						/ (2 * SideOne * SideThree)))
						* 180 / Math.PI;
				double Anglez = (Math.acos((Math.pow(SideTwo, 2)
						+ Math.pow(SideOne, 2) - Math.pow(SideThree, 2))
						/ (2 * SideTwo * SideOne)))
						* 180 / Math.PI;
				// CALCULATION VARIABLES
				double Perimeter = (SideOne + SideTwo + SideThree);
				double Semi = Perimeter / 2;
				double Area = Math.sqrt(Semi * (Semi - SideOne)
						* (Semi - SideTwo) * (Semi - SideThree));
				double R = (SideOne * SideTwo * SideThree) / (4 * Area);
				double r = (2 * Area) / (Perimeter);

				// Swing Version
				AngleX.setText("" + Anglex);
				AngleY.setText("" + Angley);
				AngleZ.setText("" + Anglez);
				Perim.setText("" + Perimeter);
				AreaBox.setText("" + Area);
				Circ.setText("" + R);
				ins.setText("" + r);
				SemiPerm.setText("" + Semi);

				// Consol Version
				System.out.println("> Angle Classification: "
						+ AngleClassification(SideOne, SideTwo, SideThree));
				System.out.println("> Side Classification: "
						+ SideClassification(SideOne, SideTwo, SideThree));
				System.out.println("> Angle x: " + Anglex);
				System.out.println("> Angle y: " + Angley);
				System.out.println("> Angle z: " + Anglez);
				System.out.println("> Perimeter: " + Perimeter
						+ ", Semi-perimeter: " + Semi);
				System.out.println("> Area: " + Area);
				System.out
						.println("> Radius of the circumscribed circle: " + R);
				System.out.println("> Radius of the inscribed circle: " + r);
				return null;
			}

		});
		frmTriangleClassification.getContentPane().add(btnStart);

		lblNewLabel = new JLabel("Side Classification");
		lblNewLabel.setBounds(293, 97, 120, 17);
		frmTriangleClassification.getContentPane().add(lblNewLabel);

		SideClassify = new JTextField();
		SideClassify.setBounds(294, 114, 100, 20);
		SideClassify.setToolTipText("");
		SideClassify.setHorizontalAlignment(SwingConstants.CENTER);
		SideClassify.setEditable(false);
		frmTriangleClassification.getContentPane().add(SideClassify);
		SideClassify.setColumns(10);

		AngleClassify = new JTextField();
		AngleClassify.setBounds(11, 114, 107, 20);
		AngleClassify.setToolTipText("");
		AngleClassify.setHorizontalAlignment(SwingConstants.CENTER);
		AngleClassify.setEditable(false);
		AngleClassify.setColumns(10);
		frmTriangleClassification.getContentPane().add(AngleClassify);

		lblAngleClassification = new JLabel("Angle Classification");
		lblAngleClassification.setBounds(11, 97, 129, 17);
		frmTriangleClassification.getContentPane().add(lblAngleClassification);

		lblAngleX = new JLabel("Angle X");
		lblAngleX.setBounds(11, 145, 103, 20);
		frmTriangleClassification.getContentPane().add(lblAngleX);

		lblAngleY = new JLabel("Angle Y");
		lblAngleY.setBounds(11, 207, 103, 20);
		frmTriangleClassification.getContentPane().add(lblAngleY);

		AngleY = new JTextField();
		AngleY.setBounds(70, 207, 139, 20);
		AngleY.setFont(new Font("Tahoma", Font.PLAIN, 11));
		AngleY.setToolTipText("");
		AngleY.setEditable(false);
		AngleY.setColumns(10);
		frmTriangleClassification.getContentPane().add(AngleY);

		lblAngleZ = new JLabel("Angle Z");
		lblAngleZ.setBounds(11, 176, 103, 20);
		frmTriangleClassification.getContentPane().add(lblAngleZ);

		AngleZ = new JTextField();
		AngleZ.setBounds(70, 176, 139, 20);
		AngleZ.setFont(new Font("Tahoma", Font.PLAIN, 11));
		AngleZ.setToolTipText("");
		AngleZ.setEditable(false);
		AngleZ.setColumns(10);
		frmTriangleClassification.getContentPane().add(AngleZ);

		AngleX = new JTextField();
		AngleX.setBounds(70, 145, 139, 20);
		AngleX.setFont(new Font("Tahoma", Font.PLAIN, 11));
		AngleX.setToolTipText("");
		AngleX.setEditable(false);
		AngleX.setColumns(10);
		frmTriangleClassification.getContentPane().add(AngleX);

		lblPerimeter = new JLabel("Perimeter");
		lblPerimeter.setBounds(219, 176, 60, 20);
		frmTriangleClassification.getContentPane().add(lblPerimeter);

		Perim = new JTextField();
		Perim.setBounds(293, 176, 101, 20);
		Perim.setToolTipText("");
		Perim.setFont(new Font("Tahoma", Font.PLAIN, 11));
		Perim.setEditable(false);
		Perim.setColumns(10);
		frmTriangleClassification.getContentPane().add(Perim);

		AreaBox = new JTextField();
		AreaBox.setBounds(252, 207, 142, 20);
		AreaBox.setToolTipText("");
		AreaBox.setEditable(false);
		AreaBox.setColumns(10);
		frmTriangleClassification.getContentPane().add(AreaBox);

		lblArea = new JLabel("Area");
		lblArea.setBounds(219, 207, 60, 20);
		frmTriangleClassification.getContentPane().add(lblArea);

		ins = new JTextField();
		ins.setBounds(11, 269, 132, 20);
		ins.setToolTipText("");
		ins.setHorizontalAlignment(SwingConstants.CENTER);
		ins.setEditable(false);
		ins.setColumns(10);
		frmTriangleClassification.getContentPane().add(ins);

		Circ = new JTextField();
		Circ.setBounds(11, 333, 132, 20);
		Circ.setToolTipText("");
		Circ.setHorizontalAlignment(SwingConstants.CENTER);
		Circ.setEditable(false);
		Circ.setColumns(10);
		frmTriangleClassification.getContentPane().add(Circ);

		lblRadiusOfThe = new JLabel("Radius of the circumscribed circle");
		lblRadiusOfThe.setBounds(11, 306, 220, 20);
		frmTriangleClassification.getContentPane().add(lblRadiusOfThe);

		lblRadiusOfThe_1 = new JLabel("Radius of the inscribed circle");
		lblRadiusOfThe_1.setBounds(11, 238, 217, 20);
		frmTriangleClassification.getContentPane().add(lblRadiusOfThe_1);

		lblSemiperimeter = new JLabel("Semi-Perimeter");
		lblSemiperimeter.setBounds(219, 145, 103, 20);
		frmTriangleClassification.getContentPane().add(lblSemiperimeter);

		SemiPerm = new JTextField();
		SemiPerm.setBounds(315, 145, 79, 20);
		SemiPerm.setToolTipText("");
		SemiPerm.setHorizontalAlignment(SwingConstants.CENTER);
		SemiPerm.setEditable(false);
		SemiPerm.setColumns(10);
		frmTriangleClassification.getContentPane().add(SemiPerm);
		
		txtRules = new JTextField();
		txtRules.setEditable(false);
		txtRules.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtRules.setHorizontalAlignment(SwingConstants.CENTER);
		txtRules.setText("Rules");
		txtRules.setBounds(219, 251, 181, 20);
		frmTriangleClassification.getContentPane().add(txtRules);
		txtRules.setColumns(10);
		
		txtInput = new JTextField();
		txtInput.setEditable(false);
		txtInput.setText("> Input 0 - 0 - 0 to Terminate");
		txtInput.setBounds(219, 273, 181, 22);
		frmTriangleClassification.getContentPane().add(txtInput);
		txtInput.setColumns(10);
		
		txtHaveFun = new JTextField();
		txtHaveFun.setEditable(false);
		txtHaveFun.setText("> Have Fun");
		txtHaveFun.setColumns(10);
		txtHaveFun.setBounds(219, 292, 181, 22);
		frmTriangleClassification.getContentPane().add(txtHaveFun);
	}
}
