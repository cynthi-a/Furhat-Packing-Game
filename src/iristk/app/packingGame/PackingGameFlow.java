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

public class PackingGameFlow extends iristk.flow.Flow {

	private iristk.situated.SystemAgentFlow agent;
	private PackablesMap packables;
	private iristk.situated.SystemAgent system;
	private List<String> packingList;

	private void initVariables() {
		system = (iristk.situated.SystemAgent) agent.getSystemAgent();
		packingList = (List<String>) new java.util.LinkedList<String>();
	}

	public iristk.situated.SystemAgent getSystem() {
		return this.system;
	}

	public void setSystem(iristk.situated.SystemAgent value) {
		this.system = value;
	}

	public List<String> getPackingList() {
		return this.packingList;
	}

	public void setPackingList(List<String> value) {
		this.packingList = value;
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
					int count = getCount(1285044316) + 1;
					incrCount(1285044316);
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
				count = getCount(1940447180) + 1;
				if (event.triggers("sense.user.enter")) {
					incrCount(1940447180);
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
			// Line: 37
			try {
				EXECUTION: {
					int count = getCount(1066376662) + 1;
					incrCount(1066376662);
					// Line: 38
					boolean chosen5 = false;
					boolean matching6 = true;
					while (!chosen5 && matching6) {
						int rand7 = random(183264084, 3, iristk.util.RandomList.RandomModel.DECK_RESHUFFLE_NOREPEAT);
						matching6 = false;
						if (true) {
							matching6 = true;
							if (rand7 >= 0 && rand7 < 1) {
								chosen5 = true;
								iristk.situated.SystemAgentFlow.say state8 = agent.new say();
								StringCreator string9 = new StringCreator();
								string9.append("Greetings! Do you want to play with me?");
								state8.setText(string9.toString());
								state8.setGesture("smile");
								if (!flowThread.callState(state8, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 38, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
						if (true) {
							matching6 = true;
							if (rand7 >= 1 && rand7 < 2) {
								chosen5 = true;
								iristk.situated.SystemAgentFlow.say state10 = agent.new say();
								StringCreator string11 = new StringCreator();
								string11.append("Hi. I am Furhat! Let's play a game.");
								state10.setText(string11.toString());
								state10.setGesture("smile");
								if (!flowThread.callState(state10, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 38, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
						if (true) {
							matching6 = true;
							if (rand7 >= 2 && rand7 < 3) {
								chosen5 = true;
								iristk.situated.SystemAgentFlow.say state12 = agent.new say();
								StringCreator string13 = new StringCreator();
								string13.append("Hey there! Let's play a game.");
								state12.setText(string13.toString());
								state12.setGesture("smile");
								if (!flowThread.callState(state12, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 38, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
					}
					// Line: 43
					ExplainGame state14 = new ExplainGame();
					flowThread.gotoState(state14, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 43, 31)));
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
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class ExplainGame extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 49
			try {
				EXECUTION: {
					int count = getCount(460332449) + 1;
					incrCount(460332449);
					iristk.situated.SystemAgentFlow.say state15 = agent.new say();
					StringCreator string16 = new StringCreator();
					string16.append("I am going on holidays. I need to pack some stuff. Do you want to help?");
					state15.setText(string16.toString());
					if (!flowThread.callState(state15, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 49, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 51
					PackIntro state17 = new PackIntro();
					flowThread.gotoState(state17, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 51, 29)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 49, 12));
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


	private class PackIntro extends Dialog {

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
			// Line: 65
			try {
				EXECUTION: {
					int count = getCount(358699161) + 1;
					incrCount(358699161);
					iristk.situated.SystemAgentFlow.say state18 = agent.new say();
					StringCreator string19 = new StringCreator();
					string19.append("I pack my bag and I take with me:");
					// Line: 65
					string19.append(randomPackable.getValue());
					state18.setText(string19.toString());
					if (!flowThread.callState(state18, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 65, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 69
					packingList.add(randomPackable.getKey());
					// Line: 70
					boolean chosen20 = false;
					boolean matching21 = true;
					while (!chosen20 && matching21) {
						int rand22 = random(914424520, 3, iristk.util.RandomList.RandomModel.DECK_RESHUFFLE_NOREPEAT);
						matching21 = false;
						if (true) {
							matching21 = true;
							if (rand22 >= 0 && rand22 < 1) {
								chosen20 = true;
								iristk.situated.SystemAgentFlow.say state23 = agent.new say();
								StringCreator string24 = new StringCreator();
								string24.append("Your turn");
								state23.setText(string24.toString());
								if (!flowThread.callState(state23, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 70, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
						if (true) {
							matching21 = true;
							if (rand22 >= 1 && rand22 < 2) {
								chosen20 = true;
								iristk.situated.SystemAgentFlow.say state25 = agent.new say();
								StringCreator string26 = new StringCreator();
								string26.append("Now you");
								state25.setText(string26.toString());
								if (!flowThread.callState(state25, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 70, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
						if (true) {
							matching21 = true;
							if (rand22 >= 2 && rand22 < 3) {
								chosen20 = true;
								iristk.situated.SystemAgentFlow.say state27 = agent.new say();
								StringCreator string28 = new StringCreator();
								string28.append("It's your turn");
								state27.setText(string28.toString());
								if (!flowThread.callState(state27, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 70, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
					}
					// Line: 75
					PlayerPacks state29 = new PlayerPacks();
					flowThread.gotoState(state29, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 75, 32)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 65, 12));
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


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 81
			try {
				EXECUTION: {
					int count = getCount(1100439041) + 1;
					incrCount(1100439041);
					iristk.situated.SystemAgentFlow.listen state30 = agent.new listen();
					if (!flowThread.callState(state30, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 81, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 81, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 84
			try {
				count = getCount(204349222) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:packables")) {
						incrCount(204349222);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 85
							if (asString(event.get("sem:packables")) > number) {
								// Line: 86
								System.out.println("You've added an item");
								iristk.situated.SystemAgentFlow.say state31 = agent.new say();
								StringCreator string32 = new StringCreator();
								string32.append("You have packed");
								// Line: 86
								string32.append(event.get("sem:packables"));
								state31.setText(string32.toString());
								if (!flowThread.callState(state31, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 85, 57)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 84, 64));
			}
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
			// Line: 94
			try {
				EXECUTION: {
					int count = getCount(32374789) + 1;
					incrCount(32374789);
					iristk.situated.SystemAgentFlow.say state33 = agent.new say();
					StringCreator string34 = new StringCreator();
					string34.append("Do you want to play again?");
					state33.setText(string34.toString());
					if (!flowThread.callState(state33, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 94, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state35 = agent.new listen();
					if (!flowThread.callState(state35, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 94, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 94, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 98
			try {
				count = getCount(1023487453) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(1023487453);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state36 = agent.new say();
							StringCreator string37 = new StringCreator();
							string37.append("Okay, let's play again.");
							state36.setText(string37.toString());
							if (!flowThread.callState(state36, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 98, 58)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 100
							PackIntro state38 = new PackIntro();
							flowThread.gotoState(state38, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 100, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 98, 58));
			}
			// Line: 102
			try {
				count = getCount(1694819250) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(1694819250);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state39 = agent.new say();
							StringCreator string40 = new StringCreator();
							string40.append("Okay, goodbye");
							state39.setText(string40.toString());
							if (!flowThread.callState(state39, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 102, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 104
							Idle state41 = new Idle();
							flowThread.gotoState(state41, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 104, 24)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 102, 57));
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
			// Line: 109
			try {
				count = getCount(1586600255) + 1;
				if (event.triggers("sense.user.speech.start")) {
					if (system.isAttending(event) && eq(event.get("speakers"), 1)) {
						incrCount(1586600255);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.gesture state42 = agent.new gesture();
							state42.setName("smile");
							if (!flowThread.callState(state42, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 109, 102)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 109, 102));
			}
			// Line: 112
			try {
				count = getCount(474675244) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:stop")) {
						incrCount(474675244);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state43 = agent.new say();
							StringCreator string44 = new StringCreator();
							string44.append("Goodbye");
							state43.setText(string44.toString());
							if (!flowThread.callState(state43, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 112, 59)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 116
							System.exit(0);
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 112, 59));
			}
			// Line: 118
			try {
				count = getCount(212628335) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(212628335);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state45 = agent.new say();
						StringCreator string46 = new StringCreator();
						string46.append("Sorry, I didn't get that.");
						state45.setText(string46.toString());
						if (!flowThread.callState(state45, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 118, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 120
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 120, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 118, 36));
			}
			// Line: 122
			try {
				count = getCount(359023572) + 1;
				if (event.triggers("sense.user.speak.side")) {
					incrCount(359023572);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.attendOther state47 = agent.new attendOther();
						state47.setMode("eyes");
						if (!flowThread.callState(state47, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 122, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						iristk.situated.SystemAgentFlow.say state48 = agent.new say();
						StringCreator string49 = new StringCreator();
						string49.append("I didn't ask you.");
						state48.setText(string49.toString());
						if (!flowThread.callState(state48, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 122, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						iristk.situated.SystemAgentFlow.attendOther state50 = agent.new attendOther();
						state50.setMode("eyes");
						if (!flowThread.callState(state50, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 122, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 126
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 126, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 122, 41));
			}
			// Line: 128
			try {
				count = getCount(2111991224) + 1;
				if (event.triggers("sense.user.speak.multi")) {
					incrCount(2111991224);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state51 = agent.new say();
						StringCreator string52 = new StringCreator();
						string52.append("Don't speak at the same time.");
						state51.setText(string52.toString());
						if (!flowThread.callState(state51, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 128, 42)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 130
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 130, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 128, 42));
			}
			// Line: 132
			try {
				count = getCount(917142466) + 1;
				if (event.triggers("sense.user.silence")) {
					incrCount(917142466);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state53 = agent.new say();
						StringCreator string54 = new StringCreator();
						string54.append("Sorry, I didn't hear anything.");
						state53.setText(string54.toString());
						if (!flowThread.callState(state53, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 132, 38)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 134
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 134, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 132, 38));
			}
			// Line: 136
			try {
				count = getCount(405662939) + 1;
				if (event.triggers("sense.user.leave")) {
					if (system.isAttending(event)) {
						incrCount(405662939);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 137
							if (system.hasUsers()) {
								iristk.situated.SystemAgentFlow.attendRandom state55 = agent.new attendRandom();
								if (!flowThread.callState(state55, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 137, 33)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 140
							} else {
								// Line: 141
								Idle state56 = new Idle();
								flowThread.gotoState(state56, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 141, 25)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 136, 69));
			}
			// Line: 144
			try {
				count = getCount(604107971) + 1;
				if (event.triggers("repeat")) {
					incrCount(604107971);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 145
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 145, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 144, 26));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


}
