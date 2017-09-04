/**
 * Author: Cynthia Lee
 * 
 * Contributors:
 * Gabriel Skantze - initial API and author of dialog-system template
 * 
 * Description:
 * This is the main class for a dialog-system based on the IrisTK template
 * 'situated-dialog'. The system models a spoken memory game in which two players,
 * an agent and a human player, are supposed to continuously add items to a packing list,
 * until the human player ceases to remember all packed items or their order.
 * 
 * Relevant Package Files:
 * PackingGameFlow.xml contains the conversation flow logic.
 * The packable items relevant for the game are listed in packables.txt.
 * The speech grammar is defined in PackingGameGrammar.abnf.
 * 
 */

package iristk.app.packingGame;

import iristk.situated.SituatedDialogSystem;
import iristk.situated.SystemAgent;
import iristk.situated.SystemAgentFlow;
import iristk.speech.SemanticGrammarContext;
import iristk.speech.Voice.Gender;
import iristk.speech.google.GoogleRecognizerFactory;
import iristk.speech.windows.WindowsSynthesizer;
import iristk.util.Language;
import iristk.cfg.ABNFGrammar;
import iristk.flow.FlowModule;

public class PackingGameSystem {
		
	public PackingGameSystem() throws Exception {
		
		SituatedDialogSystem system = new SituatedDialogSystem(this.getClass());
		SystemAgentFlow systemAgentFlow = system.addSystemAgent();
		
		SystemAgent systemAgent = systemAgentFlow.getSystemAgent();
		
		/**
		 * Different from the template 'situated-dialog', this system will only
		 * handle one user, the human game opponent.
		 */
		systemAgent.setMaxUsers(1);
		systemAgent.setInteractionDistance(2);
	
		system.setLanguage(Language.ENGLISH_US);
	
		/**
		 * Uncomment the following line if you want to enable logging
		 */
		//system.setupLogging(new File("c:/iristk_logging"), true);
		
		system.setupGUI();
		
		/**
		 * The game works without a Kinect but it is advised to connect one as it
		 * will offer a more engaging game experience, due to eye contact. Uncomment
		 * the following line if you do not wish to use a Kinect.
		 */
		//system.setupKinect();
		
		/**
		 * Choose one of the following microphones and speech recogniser sevices.
		 * I advise GoogleRecogniser as it offers the most reliable speech interpretation.
		 * However, if you do not have an internet connection, choose the WindowsRecogniser.
		 * Consult the README to see how to properly set up any other recogniser.
		 */
		//system.setupMonoMicrophone(new WindowsRecognizerFactory());
		//system.setupMonoMicrophone(new NuanceCloudRecognizerFactory());
		system.setupMonoMicrophone(new GoogleRecognizerFactory());
		//system.setupStereoMicrophones(new WindowsRecognizerFactory());
		//system.setupKinectMicrophone(new NuanceCloudRecognizerFactory());
				
		/**
		 * Uncomment the following line if you want to use a Furhat robot as an agent.
		 * Remember to replace 0.0.0.0 with the IP-address of the Furhat you
		 * want to use.
		 */
		//system.connectToBroker("furhat", "0.0.0.0");
		
		system.setupFace(new WindowsSynthesizer(), Gender.MALE);
		
		/**
		 * The following three lines set up the module and give it the needed parameters,
		 * which include a Map of the packable items, as defined in packables.txt.
		 */
		PackablesMap packables = new PackablesMap(system.getPackageFile("packables.txt"));
		system.addModule(new FlowModule(new PackingGameFlow(systemAgentFlow, packables)));
		system.loadContext("default", new SemanticGrammarContext(new ABNFGrammar(system.getPackageFile("PackingGameGrammar.abnf"))));

		
		system.loadPositions(system.getPackageFile("situation.properties"));		
		system.sendStartSignal();
	}

	public static void main(String[] args) throws Exception {
		new PackingGameSystem();
	}

}
