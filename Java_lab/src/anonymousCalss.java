import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class anonymousCalss {
	public static void main(String[] args) {
		Button b = new Button("start");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("ActionEvent occurred");
			}

		});
	}
}
