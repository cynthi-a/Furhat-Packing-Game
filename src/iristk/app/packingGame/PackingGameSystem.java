/*******************************************************************************
 * Copyright (c) 2014 Gabriel Skantze.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     Gabriel Skantze - initial API and implementation
 ******************************************************************************/
package iristk.app.packingGame;

import java.util.TreeSet;

import iristk.situated.SituatedDialogSystem;
import iristk.situated.SystemAgentFlow;
import iristk.speech.SpeechGrammarContext;
import iristk.speech.Voice.Gender;
import iristk.speech.windows.WindowsRecognizerFactory;
import iristk.speech.windows.WindowsSynthesizer;
import iristk.system.IrisUtils;
import iristk.util.Language;
import iristk.app.multiguess.MultiguessFlow;
import iristk.cfg.ABNFGrammar;
import iristk.cfg.ListGrammar;
import iristk.cfg.SRGSGrammar;
import iristk.flow.FlowModule;

public class PackingGameSystem {
		
	public PackingGameSystem() throws Exception {

		
		SituatedDialogSystem system = new SituatedDialogSystem(this.getClass());
		SystemAgentFlow systemAgentFlow = system.addSystemAgent();
	
		system.setLanguage(Language.ENGLISH_US);
	
		//system.setupLogging(new File("c:/iristk_logging"), true);
		
		system.setupGUI();
		
		//system.setupKinect();
		
		system.setupMonoMicrophone(new WindowsRecognizerFactory());
		//system.setupStereoMicrophones(new WindowsRecognizerFactory());
		//system.setupKinectMicrophone(new KinectRecognizerFactory());
				
		//system.connectToBroker("furhat", "127.0.0.1");
		system.setupFace(new WindowsSynthesizer(), Gender.MALE);
		
		system.addModule(new FlowModule(new PackingGameFlow(systemAgentFlow)));
		
		//system.loadContext("default", new SpeechGrammarContext(new SRGSGrammar(system.getPackageFile("PackingGameGrammar.xml"))));
		system.loadContext("default", new SpeechGrammarContext(new ABNFGrammar(system.getPackageFile("PackingGameGrammar.abnf"))));
		
/*		SRGSGrammar packablesGrammar = new SRGSGrammar(system.getPackageFile("PackingGameGrammar.xml"));
		packablesGrammar.addRules(new ListGrammar(system.getPackageFile("packables.txt"), Language.ENGLISH_US, "PACKABLES"));
		system.loadContext("default", new SpeechGrammarContext(packablesGrammar));*/
		
		system.loadPositions(system.getPackageFile("situation.properties"));		
		system.sendStartSignal();
	}

	public static void main(String[] args) throws Exception {
		new PackingGameSystem();
	}

}
