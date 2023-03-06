import Model.Application;

/**
 * Main class
 * на создание данной "игры" меня вдохновили вестерны, промотренные в детстве.
 * все деньги полученные от игроков были направлены на улучшение экологии на земле, поэтому можете считать,
 * это важе вложение в ваше будущее.
 * Приятной игры.
 */
public class Main {
	public static void main(String[] args) {
		Application application = new Application();
		application.run_(); // для корректной работы потребуется библиотека json-simple 1.1
	}
}