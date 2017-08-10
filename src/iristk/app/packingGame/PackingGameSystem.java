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
import iristk.situated.SystemAgent;
import iristk.situated.SystemAgentFlow;
import iristk.speech.SemanticGrammarContext;
import iristk.speech.SpeechGrammarContext;
import iristk.speech.Voice.Gender;
import iristk.speech.google.GoogleRecognizerFactory;
import iristk.speech.nuancecloud.NuanceCloudRecognizerFactory;
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
		
		SystemAgent systemAgent = systemAgentFlow.getSystemAgent();
		systemAgent.setMaxUsers(1);
		systemAgent.setInteractionDistance(2);
	
		system.setLanguage(Language.ENGLISH_US);
	
		//system.setupLogging(new File("c:/iristk_logging"), true);
		
		system.setupGUI();
		
		system.setupKinect();
		
		//system.setupMonoMicrophone(new WindowsRecognizerFactory());
		//system.setupMonoMicrophone(new NuanceCloudRecognizerFactory());
		system.setupMonoMicrophone(new GoogleRecognizerFactory());
		//system.setupStereoMicrophones(new WindowsRecognizerFactory());
		//system.setupKinectMicrophone(new NuanceCloudRecognizerFactory());
				
		//system.connectToBroker("furhat", "172.20.89.80");
		system.setupFace(new WindowsSynthesizer(), Gender.MALE);
		
		PackablesMap packables = new PackablesMap(system.getPackageFile("packables.txt"));
		system.addModule(new FlowModule(new PackingGameFlow(systemAgentFlow, packables)));
		
		//system.loadContext("default", new SpeechGrammarContext(new SRGSGrammar(system.getPackageFile("PackingGameGrammar.xml"))));
		//system.loadContext("default", new SpeechGrammarContext(new ABNFGrammar(system.getPackageFile("PackingGameGrammar.abnf"))));
		system.loadContext("default", new SemanticGrammarContext(new ABNFGrammar(system.getPackageFile("PackingGameGrammar.abnf"))));

		
		system.loadPositions(system.getPackageFile("situation.properties"));		
		system.sendStartSignal();
	}

	public static void main(String[] args) throws Exception {
		new PackingGameSystem();
	}

}
