package com.mygdx.game.desktop;

import client.singletons.StateManager;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import driver.GameLoop;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.vSyncEnabled = true;
		cfg.title = "Zhi Yin";
		cfg.width = (int)(750* StateManager.M);
		cfg.height = (int) (1334* StateManager.M);
		cfg.resizable = false;
		new LwjglApplication(new GameLoop(), cfg);
	}
}
