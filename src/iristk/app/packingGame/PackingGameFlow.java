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
import java.util.TreeSet;

public class PackingGameFlow extends iristk.flow.Flow {

	private TreeSet<String > packables;
	private iristk.situated.SystemAgent system;
	private List<String> packingList;
	private TreeSet<String > packables;

	private void initVariables() {
		system = (iristk.situated.SystemAgent) agent.getSystemAgent();
		packingList = (List<String>) new java.util.LinkedList<String>();
		packables = (TreeSet<String >) new java.util.TreeSet<String>();
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

	public TreeSet<String > getPackables() {
		return this.packables;
	}

	public void setPackables(TreeSet<String > value) {
		this.packables = value;
	}

	public TreeSet<String > getPackables() {
		return this.packables;
	}

	@Override
	public Object getVariable(String name) {
		if (name.equals("system")) return this.system;
		if (name.equals("packingList")) return this.packingList;
		if (name.equals("packables")) return this.packables;
		if (name.equals("packables")) return this.packables;
		return null;
	}


	public PackingGameFlow(TreeSet<String > packables) {
		this.packables = packables;
		initVariables();
	}

	@Override
	public State getInitialState() {return new SetUp();}


	public class SetUp extends State implements Initial {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 21
			try {
				EXECUTION: {
					int count = getCount(1285044316) + 1;
					incrCount(1285044316);
					// Line: 22
					packables.add("hat");
					packables.add("shoes");
					packables.add("hat");
					packables.add("belt");
					packables.add("comb");
					packables.add("towel");
					packables.add("bathing suit");
					packables.add("laptop");
					packables.add("cell phone");
					// Line: 33
					Idle state0 = new Idle();
					flowThread.gotoState(state0, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 33, 24)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 21, 12));
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


	private class Idle extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 38
			try {
				EXECUTION: {
					int count = getCount(1407343478) + 1;
					incrCount(1407343478);
					// Line: 39
					if (system.hasUsers()) {
						iristk.situated.SystemAgentFlow.attendRandom state1 = new iristk.situated.SystemAgentFlow.attendRandom();
						if (!flowThread.callState(state1, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 39, 33)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 41
						Greeting state2 = new Greeting();
						flowThread.gotoState(state2, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 41, 29)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 42
					} else {
						iristk.situated.SystemAgentFlow.attendNobody state3 = new iristk.situated.SystemAgentFlow.attendNobody();
						if (!flowThread.callState(state3, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 39, 33)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 38, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 46
			try {
				count = getCount(183264084) + 1;
				if (event.triggers("sense.user.enter")) {
					incrCount(183264084);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.attend state4 = new iristk.situated.SystemAgentFlow.attend();
						state4.setTarget(event.get("user"));
						if (!flowThread.callState(state4, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 46, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 48
						Greeting state5 = new Greeting();
						flowThread.gotoState(state5, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 48, 28)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 46, 36));
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
			// Line: 53
			try {
				EXECUTION: {
					int count = getCount(460332449) + 1;
					incrCount(460332449);
					// Line: 54
					boolean chosen6 = false;
					boolean matching7 = true;
					while (!chosen6 && matching7) {
						int rand8 = random(1919892312, 3, iristk.util.RandomList.RandomModel.DECK_RESHUFFLE_NOREPEAT);
						matching7 = false;
						if (true) {
							matching7 = true;
							if (rand8 >= 0 && rand8 < 1) {
								chosen6 = true;
								iristk.situated.SystemAgentFlow.say state9 = new iristk.situated.SystemAgentFlow.say();
								StringCreator string10 = new StringCreator();
								string10.append("Greetings! Do you want to play with me?");
								state9.setText(string10.toString());
								state9.setGesture("smile");
								if (!flowThread.callState(state9, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 54, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
						if (true) {
							matching7 = true;
							if (rand8 >= 1 && rand8 < 2) {
								chosen6 = true;
								iristk.situated.SystemAgentFlow.say state11 = new iristk.situated.SystemAgentFlow.say();
								StringCreator string12 = new StringCreator();
								string12.append("Hi. I am Furhat! Let's play a game.");
								state11.setText(string12.toString());
								state11.setGesture("smile");
								if (!flowThread.callState(state11, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 54, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
						if (true) {
							matching7 = true;
							if (rand8 >= 2 && rand8 < 3) {
								chosen6 = true;
								iristk.situated.SystemAgentFlow.say state13 = new iristk.situated.SystemAgentFlow.say();
								StringCreator string14 = new StringCreator();
								string14.append("Hey there! Let's play a game.");
								state13.setText(string14.toString());
								state13.setGesture("smile");
								if (!flowThread.callState(state13, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 54, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
					}
					// Line: 59
					ExplainGame state15 = new ExplainGame();
					flowThread.gotoState(state15, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 59, 31)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 53, 12));
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
			// Line: 78
			try {
				EXECUTION: {
					int count = getCount(358699161) + 1;
					incrCount(358699161);
					iristk.situated.SystemAgentFlow.say state16 = new iristk.situated.SystemAgentFlow.say();
					StringCreator string17 = new StringCreator();
					string17.append("I am going on holidays. I need to pack some stuff. Do you want to help?");
					state16.setText(string17.toString());
					if (!flowThread.callState(state16, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 78, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 80
					PackIntro state18 = new PackIntro();
					flowThread.gotoState(state18, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 80, 29)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 78, 12));
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


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 93
			try {
				EXECUTION: {
					int count = getCount(110718392) + 1;
					incrCount(110718392);
					iristk.situated.SystemAgentFlow.say state19 = new iristk.situated.SystemAgentFlow.say();
					StringCreator string20 = new StringCreator();
					string20.append("I pack my bag and I take with me:");
					// Line: 93
					string20.append(packables.first());
					state19.setText(string20.toString());
					if (!flowThread.callState(state19, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 93, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 97
					boolean chosen21 = false;
					boolean matching22 = true;
					while (!chosen21 && matching22) {
						int rand23 = random(2143192188, 3, iristk.util.RandomList.RandomModel.DECK_RESHUFFLE_NOREPEAT);
						matching22 = false;
						if (true) {
							matching22 = true;
							if (rand23 >= 0 && rand23 < 1) {
								chosen21 = true;
								iristk.situated.SystemAgentFlow.say state24 = new iristk.situated.SystemAgentFlow.say();
								StringCreator string25 = new StringCreator();
								string25.append("Your turn");
								state24.setText(string25.toString());
								if (!flowThread.callState(state24, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 97, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
						if (true) {
							matching22 = true;
							if (rand23 >= 1 && rand23 < 2) {
								chosen21 = true;
								iristk.situated.SystemAgentFlow.say state26 = new iristk.situated.SystemAgentFlow.say();
								StringCreator string27 = new StringCreator();
								string27.append("Now you");
								state26.setText(string27.toString());
								if (!flowThread.callState(state26, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 97, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
						if (true) {
							matching22 = true;
							if (rand23 >= 2 && rand23 < 3) {
								chosen21 = true;
								iristk.situated.SystemAgentFlow.say state28 = new iristk.situated.SystemAgentFlow.say();
								StringCreator string29 = new StringCreator();
								string29.append("It's your turn");
								state28.setText(string29.toString());
								if (!flowThread.callState(state28, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 97, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
					}
					// Line: 102
					PlayerPacks state30 = new PlayerPacks();
					flowThread.gotoState(state30, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 102, 32)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 93, 12));
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
			// Line: 108
			try {
				EXECUTION: {
					int count = getCount(231685785) + 1;
					incrCount(231685785);
					iristk.situated.SystemAgentFlow.listen state31 = new iristk.situated.SystemAgentFlow.listen();
					if (!flowThread.callState(state31, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 108, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 108, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 111
			try {
				count = getCount(114935352) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:packables")) {
						incrCount(114935352);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state32 = new iristk.situated.SystemAgentFlow.say();
							StringCreator string33 = new StringCreator();
							string33.append("You have packed");
							// Line: 111
							string33.append(event.get("sem:packables"));
							state32.setText(string33.toString());
							if (!flowThread.callState(state32, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 111, 64)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 113
							System.out.println("You've added an item");
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 111, 64));
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
			// Line: 119
			try {
				EXECUTION: {
					int count = getCount(1973538135) + 1;
					incrCount(1973538135);
					iristk.situated.SystemAgentFlow.say state34 = new iristk.situated.SystemAgentFlow.say();
					StringCreator string35 = new StringCreator();
					string35.append("Do you want to play again?");
					state34.setText(string35.toString());
					if (!flowThread.callState(state34, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 119, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state36 = new iristk.situated.SystemAgentFlow.listen();
					if (!flowThread.callState(state36, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 119, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 119, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 123
			try {
				count = getCount(1865127310) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(1865127310);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state37 = new iristk.situated.SystemAgentFlow.say();
							StringCreator string38 = new StringCreator();
							string38.append("Okay, let's play again.");
							state37.setText(string38.toString());
							if (!flowThread.callState(state37, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 123, 58)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 125
							PackIntro state39 = new PackIntro();
							flowThread.gotoState(state39, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 125, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 123, 58));
			}
			// Line: 127
			try {
				count = getCount(1365202186) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(1365202186);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state40 = new iristk.situated.SystemAgentFlow.say();
							StringCreator string41 = new StringCreator();
							string41.append("Okay, goodbye");
							state40.setText(string41.toString());
							if (!flowThread.callState(state40, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 127, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 129
							Idle state42 = new Idle();
							flowThread.gotoState(state42, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 129, 24)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 127, 57));
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
			// Line: 134
			try {
				count = getCount(474675244) + 1;
				if (event.triggers("sense.user.speech.start")) {
					if (system.isAttending(event) && eq(event.get("speakers"), 1)) {
						incrCount(474675244);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.gesture state43 = new iristk.situated.SystemAgentFlow.gesture();
							state43.setName("smile");
							if (!flowThread.callState(state43, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 134, 102)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 134, 102));
			}
			// Line: 137
			try {
				count = getCount(932583850) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(932583850);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state44 = new iristk.situated.SystemAgentFlow.say();
						StringCreator string45 = new StringCreator();
						string45.append("Sorry, I didn't get that.");
						state44.setText(string45.toString());
						if (!flowThread.callState(state44, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 137, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 139
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 139, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 137, 36));
			}
			// Line: 141
			try {
				count = getCount(1579572132) + 1;
				if (event.triggers("sense.user.speak.side")) {
					incrCount(1579572132);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.attendOther state46 = new iristk.situated.SystemAgentFlow.attendOther();
						state46.setMode("eyes");
						if (!flowThread.callState(state46, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 141, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						iristk.situated.SystemAgentFlow.say state47 = new iristk.situated.SystemAgentFlow.say();
						StringCreator string48 = new StringCreator();
						string48.append("I didn't ask you.");
						state47.setText(string48.toString());
						if (!flowThread.callState(state47, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 141, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						iristk.situated.SystemAgentFlow.attendOther state49 = new iristk.situated.SystemAgentFlow.attendOther();
						state49.setMode("eyes");
						if (!flowThread.callState(state49, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 141, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 145
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 145, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 141, 41));
			}
			// Line: 147
			try {
				count = getCount(305808283) + 1;
				if (event.triggers("sense.user.speak.multi")) {
					incrCount(305808283);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state50 = new iristk.situated.SystemAgentFlow.say();
						StringCreator string51 = new StringCreator();
						string51.append("Don't speak at the same time.");
						state50.setText(string51.toString());
						if (!flowThread.callState(state50, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 147, 42)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 149
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 149, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 147, 42));
			}
			// Line: 151
			try {
				count = getCount(292938459) + 1;
				if (event.triggers("sense.user.silence")) {
					incrCount(292938459);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state52 = new iristk.situated.SystemAgentFlow.say();
						StringCreator string53 = new StringCreator();
						string53.append("Sorry, I didn't hear anything.");
						state52.setText(string53.toString());
						if (!flowThread.callState(state52, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 151, 38)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 153
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 153, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 151, 38));
			}
			// Line: 155
			try {
				count = getCount(1993134103) + 1;
				if (event.triggers("sense.user.leave")) {
					if (system.isAttending(event)) {
						incrCount(1993134103);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 156
							if (system.hasUsers()) {
								iristk.situated.SystemAgentFlow.attendRandom state54 = new iristk.situated.SystemAgentFlow.attendRandom();
								if (!flowThread.callState(state54, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 156, 33)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 159
							} else {
								// Line: 160
								Idle state55 = new Idle();
								flowThread.gotoState(state55, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 160, 25)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 155, 69));
			}
			// Line: 163
			try {
				count = getCount(1404928347) + 1;
				if (event.triggers("repeat")) {
					incrCount(1404928347);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 164
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 164, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 163, 26));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


}
