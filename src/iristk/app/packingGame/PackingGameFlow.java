package iristk.app.packingGame;

import java.util.List;
import java.io.File;
import iristk.xml.XmlMarshaller.XMLLocation;
import iristk.system.Event;
import iristk.flow.*;
import iristk.util.Record;
import static iristk.util.Converters.*;
import static iristk.flow.State.*;
import java.util.List;
import java.util.LinkedList;
import javafx.util.Pair;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Random;

public class PackingGameFlow extends iristk.flow.Flow {

	private iristk.situated.SystemAgentFlow agent;
	private PackablesMap packables;
	private iristk.situated.SystemAgent system;
	private LinkedList<String> packingList;
	private Random random;

	private void initVariables() {
		system = (iristk.situated.SystemAgent) agent.getSystemAgent();
		packingList = (LinkedList<String>) new java.util.LinkedList<String>();
		random = (Random) new Random();
	}

	public iristk.situated.SystemAgent getSystem() {
		return this.system;
	}

	public void setSystem(iristk.situated.SystemAgent value) {
		this.system = value;
	}

	public LinkedList<String> getPackingList() {
		return this.packingList;
	}

	public void setPackingList(LinkedList<String> value) {
		this.packingList = value;
	}

	public Random getRandom() {
		return this.random;
	}

	public void setRandom(Random value) {
		this.random = value;
	}

	public iristk.situated.SystemAgentFlow getAgent() {
		return this.agent;
	}

	public PackablesMap getPackables() {
		return this.packables;
	}

	@Override
	public Object getVariable(String name) {
		if (name.equals("system")) return this.system;
		if (name.equals("packingList")) return this.packingList;
		if (name.equals("random")) return this.random;
		if (name.equals("agent")) return this.agent;
		if (name.equals("packables")) return this.packables;
		return null;
	}


	public PackingGameFlow(iristk.situated.SystemAgentFlow agent, PackablesMap packables) {
		this.agent = agent;
		this.packables = packables;
		initVariables();
	}

	@Override
	public State getInitialState() {return new Idle();}


	public class Idle extends Dialog implements Initial {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 22
			try {
				EXECUTION: {
					int count = getCount(1407343478) + 1;
					incrCount(1407343478);
					// Line: 23
					if (system.hasUsers()) {
						iristk.situated.SystemAgentFlow.attendRandom state0 = agent.new attendRandom();
						if (!flowThread.callState(state0, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 23, 33)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 25
						Greeting state1 = new Greeting();
						flowThread.gotoState(state1, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 25, 29)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 26
					} else {
						iristk.situated.SystemAgentFlow.attendNobody state2 = agent.new attendNobody();
						if (!flowThread.callState(state2, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 23, 33)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 22, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 30
			try {
				count = getCount(183264084) + 1;
				if (event.triggers("sense.user.enter")) {
					incrCount(183264084);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.attend state3 = agent.new attend();
						state3.setTarget(event.get("user"));
						if (!flowThread.callState(state3, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 30, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 32
						Greeting state4 = new Greeting();
						flowThread.gotoState(state4, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 32, 28)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 30, 36));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class WaitToContinue extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 37
			try {
				EXECUTION: {
					int count = getCount(460332449) + 1;
					incrCount(460332449);
					iristk.situated.SystemAgentFlow.listen state5 = agent.new listen();
					if (!flowThread.callState(state5, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 37, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 39
					flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 39, 14)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 37, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 41
			try {
				count = getCount(1143839598) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:continue")) {
						incrCount(1143839598);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 42
							PackIntro state6 = new PackIntro();
							flowThread.gotoState(state6, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 42, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 41, 63));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Greeting extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 47
			try {
				EXECUTION: {
					int count = getCount(517938326) + 1;
					incrCount(517938326);
					// Line: 48
					boolean chosen7 = false;
					boolean matching8 = true;
					while (!chosen7 && matching8) {
						int rand9 = random(914424520, 3, iristk.util.RandomList.RandomModel.DECK_RESHUFFLE_NOREPEAT);
						matching8 = false;
						if (true) {
							matching8 = true;
							if (rand9 >= 0 && rand9 < 1) {
								chosen7 = true;
								iristk.situated.SystemAgentFlow.say state10 = agent.new say();
								StringCreator string11 = new StringCreator();
								string11.append("Greetings! Do you want to play with me?");
								state10.setText(string11.toString());
								state10.setGesture("smile");
								if (!flowThread.callState(state10, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 48, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
						if (true) {
							matching8 = true;
							if (rand9 >= 1 && rand9 < 2) {
								chosen7 = true;
								iristk.situated.SystemAgentFlow.say state12 = agent.new say();
								StringCreator string13 = new StringCreator();
								string13.append("Hi. I am Furhat! Let's play a game.");
								state12.setText(string13.toString());
								state12.setGesture("smile");
								if (!flowThread.callState(state12, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 48, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
						if (true) {
							matching8 = true;
							if (rand9 >= 2 && rand9 < 3) {
								chosen7 = true;
								iristk.situated.SystemAgentFlow.say state14 = agent.new say();
								StringCreator string15 = new StringCreator();
								string15.append("Hey there! Let's play a game.");
								state14.setText(string15.toString());
								state14.setGesture("smile");
								if (!flowThread.callState(state14, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 48, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
					}
					// Line: 53
					ExplainGame state16 = new ExplainGame();
					flowThread.gotoState(state16, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 53, 31)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 47, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class ExplainGame extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 58
			try {
				EXECUTION: {
					int count = getCount(2143192188) + 1;
					incrCount(2143192188);
					iristk.situated.SystemAgentFlow.prompt state17 = agent.new prompt();
					StringCreator string18 = new StringCreator();
					string18.append("The game goes like this:");
					state17.setText(string18.toString());
					if (!flowThread.callState(state17, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 58, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state19 = agent.new say();
					StringCreator string20 = new StringCreator();
					string20.append("I will start by saying I pack my bag and I take with me for example");
					// Line: 58
					string20.append(packables.getRandom().getValue());
					string20.append(". 			You then have to repeat the exact same sentence. At the end, you add another item to the packing list and it is my turn again. 			We continue this until one of us either fails to recall the exact sequence of the items or all items have been packed. 			Do you understand the rules?");
					state19.setText(string20.toString());
					if (!flowThread.callState(state19, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 58, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state21 = agent.new listen();
					state21.setTimeout(3000);
					if (!flowThread.callState(state21, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 58, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 58, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 66
			try {
				count = getCount(204349222) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(204349222);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state22 = agent.new say();
							StringCreator string23 = new StringCreator();
							string23.append("Okay, let's play");
							state22.setText(string23.toString());
							if (!flowThread.callState(state22, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 66, 59)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 68
							PackIntro state24 = new PackIntro();
							flowThread.gotoState(state24, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 68, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 66, 59));
			}
			// Line: 70
			try {
				count = getCount(114935352) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(114935352);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state25 = agent.new say();
							StringCreator string26 = new StringCreator();
							string26.append("Okay, let Cynthia explain it again.");
							state25.setText(string26.toString());
							if (!flowThread.callState(state25, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 70, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 72
							WaitToContinue state27 = new WaitToContinue();
							flowThread.gotoState(state27, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 72, 34)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 70, 57));
			}
			// Line: 74
			try {
				count = getCount(32374789) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:continue")) {
						incrCount(32374789);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state28 = agent.new say();
							StringCreator string29 = new StringCreator();
							string29.append("Ok if you already know the rules, let's just start. Ready?");
							state28.setText(string29.toString());
							if (!flowThread.callState(state28, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 74, 63)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 76
							PackIntro state30 = new PackIntro();
							flowThread.gotoState(state30, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 76, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 74, 63));
			}
			// Line: 78
			try {
				count = getCount(1023487453) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(1023487453);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state31 = agent.new say();
						StringCreator string32 = new StringCreator();
						string32.append("Sorry, what were you saying?");
						state31.setText(string32.toString());
						if (!flowThread.callState(state31, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 78, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						iristk.situated.SystemAgentFlow.listen state33 = agent.new listen();
						state33.setTimeout(3000);
						if (!flowThread.callState(state33, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 78, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 78, 36));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class PackIntro extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 86
			try {
				EXECUTION: {
					int count = getCount(1694819250) + 1;
					incrCount(1694819250);
					iristk.situated.SystemAgentFlow.say state34 = agent.new say();
					StringCreator string35 = new StringCreator();
					string35.append("I pack my bag and I take with me:");
					state34.setText(string35.toString());
					if (!flowThread.callState(state34, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 86, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 88
					PackRandomItem state36 = new PackRandomItem();
					if (!flowThread.callState(state36, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 88, 34)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 89
					boolean chosen37 = false;
					boolean matching38 = true;
					while (!chosen37 && matching38) {
						int rand39 = random(1586600255, 3, iristk.util.RandomList.RandomModel.DECK_RESHUFFLE_NOREPEAT);
						matching38 = false;
						if (true) {
							matching38 = true;
							if (rand39 >= 0 && rand39 < 1) {
								chosen37 = true;
								iristk.situated.SystemAgentFlow.say state40 = agent.new say();
								StringCreator string41 = new StringCreator();
								string41.append("Your turn");
								state40.setText(string41.toString());
								if (!flowThread.callState(state40, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 89, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
						if (true) {
							matching38 = true;
							if (rand39 >= 1 && rand39 < 2) {
								chosen37 = true;
								iristk.situated.SystemAgentFlow.say state42 = agent.new say();
								StringCreator string43 = new StringCreator();
								string43.append("Now you");
								state42.setText(string43.toString());
								if (!flowThread.callState(state42, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 89, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
						if (true) {
							matching38 = true;
							if (rand39 >= 2 && rand39 < 3) {
								chosen37 = true;
								iristk.situated.SystemAgentFlow.say state44 = agent.new say();
								StringCreator string45 = new StringCreator();
								string45.append("It's your turn");
								state44.setText(string45.toString());
								if (!flowThread.callState(state44, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 89, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
					}
					// Line: 94
					PlayerPacks state46 = new PlayerPacks();
					flowThread.gotoState(state46, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 94, 33)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 86, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class UserAddsItem extends Dialog {

		final State currentState = this;
		public String newItem = null;

		public void setNewItem(Object value) {
			if (value != null) {
				newItem = asString(value);
				params.put("newItem", value);
			}
		}


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 100
			try {
				EXECUTION: {
					int count = getCount(1579572132) + 1;
					incrCount(1579572132);
					// Line: 101
					if (!packingList.contains(newItem)) {
						// Line: 102
						packingList.add(newItem);
						// Line: 103
						System.out.println(packingList);
						// Line: 104
					} else if (packingList.contains(newItem)) {
						iristk.situated.SystemAgentFlow.say state47 = agent.new say();
						StringCreator string48 = new StringCreator();
						// Line: 104
						string48.append(newItem);
						string48.append("is already in the packing list");
						state47.setText(string48.toString());
						if (!flowThread.callState(state47, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 101, 46)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 106
						CheckAgain state49 = new CheckAgain();
						flowThread.gotoState(state49, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 106, 32)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 108
					flowThread.returnFromCall(this, null, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 108, 12)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 100, 13));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class PlayerPacks extends Dialog {

		final State currentState = this;

		public Iterator packingListIterator = (Iterator) packingList.iterator();
		public List responseList = asList(new LinkedList<String>());

		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 115
			try {
				EXECUTION: {
					int count = getCount(1404928347) + 1;
					incrCount(1404928347);
					iristk.situated.SystemAgentFlow.listen state50 = agent.new listen();
					state50.setEndSil(2000);
					state50.setTimeout(10000);
					if (!flowThread.callState(state50, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 115, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 115, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 119
			try {
				count = getCount(604107971) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:packables")) {
						incrCount(604107971);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 120
							String response = asString(asString(event.get("text")).toLowerCase());
							// Line: 122
							Scanner sc = new Scanner(response);
							while(sc.hasNext()) {
								String nextWord = sc.next();
								if (packables.containsKey(nextWord)) {
									responseList.add(nextWord);
								}
							};
							// Line: 132
							Iterator responseIterator = (Iterator) responseList.iterator();
							// Line: 134
							{
								RepeatHandler handler51 = new RepeatHandler();
								while (packingListIterator.hasNext()) {
									// Line: 135
									String nextResponse = asString(responseIterator.next());
									// Line: 136
									if (!packingListIterator.next().equals(nextResponse) && packingListIterator.hasNext()) {
										// Line: 138
										if (packingList.contains(nextResponse)) {
											iristk.situated.SystemAgentFlow.say state52 = agent.new say();
											StringCreator string53 = new StringCreator();
											// Line: 138
											string53.append(nextResponse);
											string53.append("is in the packing list but at a different position");
											state52.setText(string53.toString());
											if (!flowThread.callState(state52, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 138, 53)))) {
												eventResult = EVENT_ABORTED;
												break EXECUTION;
											}
											// Line: 140
										} else if (!packingList.contains(nextResponse)) {
											iristk.situated.SystemAgentFlow.say state54 = agent.new say();
											StringCreator string55 = new StringCreator();
											// Line: 140
											string55.append(nextResponse);
											string55.append("is not in the packing list");
											state54.setText(string55.toString());
											if (!flowThread.callState(state54, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 138, 53)))) {
												eventResult = EVENT_ABORTED;
												break EXECUTION;
											}
										}
										// Line: 143
										CheckAgain state56 = new CheckAgain();
										flowThread.gotoState(state56, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 143, 32)));
										eventResult = EVENT_ABORTED;
										break EXECUTION;
									}
									handler51.next();
								}
							}
							// Line: 147
							if (responseIterator.hasNext()) {
								// Line: 148
								UserAddsItem state57 = new UserAddsItem();
								state57.setNewItem(responseIterator.next());
								if (!flowThread.callState(state57, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 148, 69)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 149
							} else if (!responseIterator.hasNext()) {
								iristk.situated.SystemAgentFlow.say state58 = agent.new say();
								StringCreator string59 = new StringCreator();
								string59.append("Seems like you forgot to add a new item to the list");
								state58.setText(string59.toString());
								if (!flowThread.callState(state58, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 147, 42)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 151
								CheckAgain state60 = new CheckAgain();
								flowThread.gotoState(state60, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 151, 31)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 154
							FurhatPacks state61 = new FurhatPacks();
							flowThread.gotoState(state61, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 154, 31)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 119, 64));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class FurhatPacks extends Dialog {

		final State currentState = this;

		public Iterator packingListIterator = (Iterator) packingList.iterator();
		public boolean furhatFails = (boolean) false;

		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 164
			try {
				EXECUTION: {
					int count = getCount(1192108080) + 1;
					incrCount(1192108080);
					// Line: 165
					boolean chosen62 = false;
					boolean matching63 = true;
					while (!chosen62 && matching63) {
						int rand64 = random(1068824137, 4, iristk.util.RandomList.RandomModel.DECK_RESHUFFLE_NOREPEAT);
						matching63 = false;
						if (true) {
							matching63 = true;
							if (rand64 >= 0 && rand64 < 1) {
								chosen62 = true;
								iristk.situated.SystemAgentFlow.say state65 = agent.new say();
								StringCreator string66 = new StringCreator();
								string66.append("OK it's my turn now");
								state65.setText(string66.toString());
								state65.setGesture("nod");
								if (!flowThread.callState(state65, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 165, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
						if (true) {
							matching63 = true;
							if (rand64 >= 1 && rand64 < 2) {
								chosen62 = true;
								iristk.situated.SystemAgentFlow.say state67 = agent.new say();
								StringCreator string68 = new StringCreator();
								string68.append("Alright then. My turn");
								state67.setText(string68.toString());
								if (!flowThread.callState(state67, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 165, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
						if (true) {
							matching63 = true;
							if (rand64 >= 2 && rand64 < 3) {
								chosen62 = true;
								iristk.situated.SystemAgentFlow.say state69 = agent.new say();
								StringCreator string70 = new StringCreator();
								string70.append("Good job. Now me");
								state69.setText(string70.toString());
								state69.setGesture("nod");
								if (!flowThread.callState(state69, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 165, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
						if (true) {
							matching63 = true;
							if (rand64 >= 3 && rand64 < 4) {
								chosen62 = true;
								iristk.situated.SystemAgentFlow.say state71 = agent.new say();
								StringCreator string72 = new StringCreator();
								string72.append("Well done. I will go on");
								state71.setText(string72.toString());
								if (!flowThread.callState(state71, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 165, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
					}
					iristk.situated.SystemAgentFlow.say state73 = agent.new say();
					StringCreator string74 = new StringCreator();
					string74.append("I pack my bag and I take with me");
					// Line: 165
					{
						RepeatHandler handler75 = new RepeatHandler();
						while (packingListIterator.hasNext()) {
							// Line: 165
							string74.append(packables.get(packingListIterator.next()));
							handler75.next();
						}
					}
					string74.append("and");
					state73.setText(string74.toString());
					if (!flowThread.callState(state73, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 164, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 180
					if (packingList.size() >= 10) {
						// Line: 181
						if (random.nextFloat() <= 0.7) {
							// Line: 182
							FailRound state76 = new FailRound();
							flowThread.gotoState(state76, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 182, 31)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 183
						} else {
							// Line: 184
							PackRandomItem state77 = new PackRandomItem();
							if (!flowThread.callState(state77, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 184, 37)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						// Line: 186
					} else if (packingList.size() >= 6) {
						// Line: 187
						if (random.nextFloat() <= 0.5) {
							// Line: 188
							FailRound state78 = new FailRound();
							flowThread.gotoState(state78, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 188, 32)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 189
						} else {
							// Line: 190
							PackRandomItem state79 = new PackRandomItem();
							if (!flowThread.callState(state79, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 190, 37)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						// Line: 192
					} else if (packingList.size() >= 4) {
						// Line: 193
						if (random.nextFloat() <= 0.3) {
							// Line: 194
							FailRound state80 = new FailRound();
							flowThread.gotoState(state80, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 194, 32)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 195
						} else {
							// Line: 196
							PackRandomItem state81 = new PackRandomItem();
							if (!flowThread.callState(state81, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 196, 37)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						// Line: 198
					} else if (packingList.size() >= 2) {
						// Line: 199
						if (random.nextFloat() <= 0.2) {
							// Line: 200
							FailRound state82 = new FailRound();
							flowThread.gotoState(state82, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 200, 32)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 201
						} else {
							// Line: 202
							PackRandomItem state83 = new PackRandomItem();
							if (!flowThread.callState(state83, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 202, 38)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						// Line: 204
					} else {
						// Line: 205
						PackRandomItem state84 = new PackRandomItem();
						if (!flowThread.callState(state84, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 205, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
					}
					// Line: 209
					boolean chosen85 = false;
					boolean matching86 = true;
					while (!chosen85 && matching86) {
						int rand87 = random(991505714, 2, iristk.util.RandomList.RandomModel.DECK_RESHUFFLE_NOREPEAT);
						matching86 = false;
						if (true) {
							matching86 = true;
							if (rand87 >= 0 && rand87 < 1) {
								chosen85 = true;
								iristk.situated.SystemAgentFlow.say state88 = agent.new say();
								StringCreator string89 = new StringCreator();
								string89.append("Now you");
								state88.setText(string89.toString());
								if (!flowThread.callState(state88, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 209, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
						if (true) {
							matching86 = true;
							if (rand87 >= 1 && rand87 < 2) {
								chosen85 = true;
								iristk.situated.SystemAgentFlow.say state90 = agent.new say();
								StringCreator string91 = new StringCreator();
								string91.append("Your turn");
								state90.setText(string91.toString());
								if (!flowThread.callState(state90, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 209, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
					}
					// Line: 213
					PlayerPacks state92 = new PlayerPacks();
					flowThread.gotoState(state92, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 213, 31)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 164, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class FailRound extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 219
			try {
				EXECUTION: {
					int count = getCount(2085857771) + 1;
					incrCount(2085857771);
					// Line: 220
					boolean chosen93 = false;
					boolean matching94 = true;
					while (!chosen93 && matching94) {
						int rand95 = random(248609774, 1, iristk.util.RandomList.RandomModel.DECK_RESHUFFLE_NOREPEAT);
						matching94 = false;
						if (true) {
							matching94 = true;
							if (rand95 >= 0 && rand95 < 1) {
								chosen93 = true;
								iristk.situated.SystemAgentFlow.say state96 = agent.new say();
								StringCreator string97 = new StringCreator();
								string97.append("I forgot which item comes next. You win.");
								state96.setText(string97.toString());
								state96.setGesture("express_sad");
								if (!flowThread.callState(state96, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 220, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
					}
					// Line: 224
					CheckAgain state98 = new CheckAgain();
					flowThread.gotoState(state98, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 224, 30)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 219, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class PackRandomItem extends State {

		final State currentState = this;

		public Pair<String,String> randomPackable = (Pair<String,String>) packables.getRandom();

		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 230
			try {
				EXECUTION: {
					int count = getCount(344560770) + 1;
					incrCount(344560770);
					// Line: 232
					{
						RepeatHandler handler99 = new RepeatHandler();
						while (packingList.contains(randomPackable.getKey())) {
							// Line: 233
							randomPackable = packables.getRandom();
							handler99.next();
						}
					}
					// Line: 236
					packingList.add(randomPackable.getKey());
					iristk.situated.SystemAgentFlow.say state100 = agent.new say();
					StringCreator string101 = new StringCreator();
					// Line: 236
					string101.append(randomPackable.getValue());
					state100.setText(string101.toString());
					if (!flowThread.callState(state100, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 230, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 240
					System.out.println("Packing list: " + packingList);
					// Line: 241
					flowThread.returnFromCall(this, null, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 241, 13)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 230, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class ClearPackingList extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 246
			try {
				EXECUTION: {
					int count = getCount(2054881392) + 1;
					incrCount(2054881392);
					// Line: 247
					packingList.clear();
					// Line: 248
					flowThread.returnFromCall(this, null, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 248, 13)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 246, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class CheckAgain extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 254
			try {
				EXECUTION: {
					int count = getCount(607635164) + 1;
					incrCount(607635164);
					// Line: 255
					boolean chosen102 = false;
					boolean matching103 = true;
					while (!chosen102 && matching103) {
						int rand104 = random(529116035, 3, iristk.util.RandomList.RandomModel.DECK_RESHUFFLE_NOREPEAT);
						matching103 = false;
						if (true) {
							matching103 = true;
							if (rand104 >= 0 && rand104 < 1) {
								chosen102 = true;
								iristk.situated.SystemAgentFlow.say state105 = agent.new say();
								StringCreator string106 = new StringCreator();
								string106.append("This round, we managed to remember");
								// Line: 255
								string106.append(packingList.size());
								// Line: 255
								if (packingList.size()==1) {
									string106.append("item only");
									// Line: 255
								} else {
									string106.append("items");
								}
								state105.setText(string106.toString());
								state105.setGesture("brow_raise");
								if (!flowThread.callState(state105, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 255, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
						if (true) {
							matching103 = true;
							if (rand104 >= 1 && rand104 < 2) {
								chosen102 = true;
								iristk.situated.SystemAgentFlow.say state107 = agent.new say();
								StringCreator string108 = new StringCreator();
								string108.append("We remembered");
								// Line: 255
								string108.append(packingList.size());
								// Line: 255
								if (packingList.size()==1) {
									string108.append("item");
									// Line: 255
								} else {
									string108.append("items");
								}
								string108.append("in this round");
								state107.setText(string108.toString());
								state107.setGesture("brow_raise");
								if (!flowThread.callState(state107, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 255, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
						if (true) {
							matching103 = true;
							if (rand104 >= 2 && rand104 < 3) {
								chosen102 = true;
								iristk.situated.SystemAgentFlow.say state109 = agent.new say();
								StringCreator string110 = new StringCreator();
								string110.append("Let's see if we can beat");
								// Line: 255
								string110.append(packingList.size());
								// Line: 255
								if (packingList.size()==1) {
									string110.append("item");
									// Line: 255
								} else {
									string110.append("items");
								}
								string110.append("in the next round");
								state109.setText(string110.toString());
								state109.setGesture("brow_raise");
								if (!flowThread.callState(state109, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 255, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
					}
					// Line: 260
					boolean chosen111 = false;
					boolean matching112 = true;
					while (!chosen111 && matching112) {
						int rand113 = random(242481580, 3, iristk.util.RandomList.RandomModel.DECK_RESHUFFLE_NOREPEAT);
						matching112 = false;
						if (true) {
							matching112 = true;
							if (rand113 >= 0 && rand113 < 1) {
								chosen111 = true;
								iristk.situated.SystemAgentFlow.say state114 = agent.new say();
								StringCreator string115 = new StringCreator();
								string115.append("Do you want to play again?");
								state114.setText(string115.toString());
								state114.setGesture("smile");
								if (!flowThread.callState(state114, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 260, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
						if (true) {
							matching112 = true;
							if (rand113 >= 1 && rand113 < 2) {
								chosen111 = true;
								iristk.situated.SystemAgentFlow.say state116 = agent.new say();
								StringCreator string117 = new StringCreator();
								string117.append("Would you like another round?");
								state116.setText(string117.toString());
								if (!flowThread.callState(state116, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 260, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
						if (true) {
							matching112 = true;
							if (rand113 >= 2 && rand113 < 3) {
								chosen111 = true;
								iristk.situated.SystemAgentFlow.say state118 = agent.new say();
								StringCreator string119 = new StringCreator();
								string119.append("Shall we try again?");
								state118.setText(string119.toString());
								if (!flowThread.callState(state118, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 260, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
					}
					iristk.situated.SystemAgentFlow.listen state120 = agent.new listen();
					state120.setTimeout(9000);
					if (!flowThread.callState(state120, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 254, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 254, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 267
			try {
				count = getCount(1627800613) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(1627800613);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state121 = agent.new say();
							StringCreator string122 = new StringCreator();
							string122.append("Okay, let's play again.");
							state121.setText(string122.toString());
							state121.setGesture("smile");
							if (!flowThread.callState(state121, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 267, 58)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 269
							ClearPackingList state123 = new ClearPackingList();
							if (!flowThread.callState(state123, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 269, 36)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 270
							PackIntro state124 = new PackIntro();
							flowThread.gotoState(state124, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 270, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 267, 58));
			}
			// Line: 272
			try {
				count = getCount(943010986) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(943010986);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state125 = agent.new say();
							StringCreator string126 = new StringCreator();
							string126.append("Okay, goodbye");
							state125.setText(string126.toString());
							state125.setGesture("express_sad");
							if (!flowThread.callState(state125, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 272, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 274
							ClearPackingList state127 = new ClearPackingList();
							if (!flowThread.callState(state127, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 274, 36)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 275
							WaitToContinue state128 = new WaitToContinue();
							flowThread.gotoState(state128, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 275, 34)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 272, 57));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Dialog extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 280
			try {
				count = getCount(325333723) + 1;
				if (event.triggers("sense.user.speech.start")) {
					if (system.isAttending(event) && eq(event.get("speakers"), 1)) {
						incrCount(325333723);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.gesture state129 = agent.new gesture();
							state129.setName("smile");
							if (!flowThread.callState(state129, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 280, 102)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 280, 102));
			}
			// Line: 283
			try {
				count = getCount(1937962514) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:stop")) {
						incrCount(1937962514);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state130 = agent.new say();
							StringCreator string131 = new StringCreator();
							string131.append("Goodbye");
							state130.setText(string131.toString());
							if (!flowThread.callState(state130, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 283, 59)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 287
							ClearPackingList state132 = new ClearPackingList();
							if (!flowThread.callState(state132, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 287, 36)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 288
							WaitToContinue state133 = new WaitToContinue();
							flowThread.gotoState(state133, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 288, 34)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 283, 59));
			}
			// Line: 290
			try {
				count = getCount(242131142) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(242131142);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state134 = agent.new say();
						StringCreator string135 = new StringCreator();
						string135.append("Sorry, I didn't get that.");
						state134.setText(string135.toString());
						if (!flowThread.callState(state134, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 290, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 292
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 292, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 290, 36));
			}
			// Line: 294
			try {
				count = getCount(1433867275) + 1;
				if (event.triggers("sense.user.speak.side")) {
					incrCount(1433867275);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.attendOther state136 = agent.new attendOther();
						state136.setMode("eyes");
						if (!flowThread.callState(state136, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 294, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						iristk.situated.SystemAgentFlow.say state137 = agent.new say();
						StringCreator string138 = new StringCreator();
						string138.append("I didn't ask you.");
						state137.setText(string138.toString());
						if (!flowThread.callState(state137, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 294, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						iristk.situated.SystemAgentFlow.attendOther state139 = agent.new attendOther();
						state139.setMode("eyes");
						if (!flowThread.callState(state139, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 294, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 298
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 298, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 294, 41));
			}
			// Line: 300
			try {
				count = getCount(1744347043) + 1;
				if (event.triggers("sense.user.speak.multi")) {
					incrCount(1744347043);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state140 = agent.new say();
						StringCreator string141 = new StringCreator();
						string141.append("Don't speak at the same time.");
						state140.setText(string141.toString());
						if (!flowThread.callState(state140, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 300, 42)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 302
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 302, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 300, 42));
			}
			// Line: 304
			try {
				count = getCount(662441761) + 1;
				if (event.triggers("sense.user.silence")) {
					incrCount(662441761);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state142 = agent.new say();
						StringCreator string143 = new StringCreator();
						string143.append("Sorry, I didn't hear anything.");
						state142.setText(string143.toString());
						if (!flowThread.callState(state142, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 304, 38)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 306
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 306, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 304, 38));
			}
			// Line: 308
			try {
				count = getCount(1023714065) + 1;
				if (event.triggers("sense.user.leave")) {
					if (system.isAttending(event)) {
						incrCount(1023714065);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 309
							if (system.hasUsers()) {
								iristk.situated.SystemAgentFlow.attendRandom state144 = agent.new attendRandom();
								if (!flowThread.callState(state144, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 309, 33)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 311
							} else {
								// Line: 312
								Idle state145 = new Idle();
								flowThread.gotoState(state145, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 312, 25)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 308, 70));
			}
			// Line: 315
			try {
				count = getCount(1971489295) + 1;
				if (event.triggers("repeat")) {
					incrCount(1971489295);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 316
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 316, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 315, 26));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


}
