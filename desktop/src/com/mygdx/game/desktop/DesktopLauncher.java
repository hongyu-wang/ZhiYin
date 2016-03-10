package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import driver.GameLoop;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.vSyncEnabled = true;
		cfg.title = "Zhi Yin";
		cfg.width = 375;
		cfg.height = 667;

		new LwjglApplication(new GameLoop(), cfg);
	}
}
