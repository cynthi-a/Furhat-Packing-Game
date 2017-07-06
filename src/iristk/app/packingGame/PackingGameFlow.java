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

	private iristk.situated.SystemAgentFlow agent;
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

	public iristk.situated.SystemAgentFlow getAgent() {
		return this.agent;
	}

	@Override
	public Object getVariable(String name) {
		if (name.equals("system")) return this.system;
		if (name.equals("packingList")) return this.packingList;
		if (name.equals("packables")) return this.packables;
		if (name.equals("agent")) return this.agent;
		return null;
	}


	public PackingGameFlow(iristk.situated.SystemAgentFlow agent) {
		this.agent = agent;
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
			// Line: 19
			try {
				EXECUTION: {
					int count = getCount(1285044316) + 1;
					incrCount(1285044316);
					// Line: 20
					packables.add("a hat"); packables.add("a pair of shoes"); System.out.println(packables.first());
					// Line: 21
					Idle state0 = new Idle();
					flowThread.gotoState(state0, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 21, 24)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 19, 12));
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
			// Line: 26
			try {
				EXECUTION: {
					int count = getCount(1407343478) + 1;
					incrCount(1407343478);
					// Line: 27
					if (system.hasUsers()) {
						iristk.situated.SystemAgentFlow.attendRandom state1 = agent.new attendRandom();
						if (!flowThread.callState(state1, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 27, 33)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 29
						Greeting state2 = new Greeting();
						flowThread.gotoState(state2, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 29, 29)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 30
					} else {
						iristk.situated.SystemAgentFlow.attendNobody state3 = agent.new attendNobody();
						if (!flowThread.callState(state3, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 27, 33)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 26, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 34
			try {
				count = getCount(183264084) + 1;
				if (event.triggers("sense.user.enter")) {
					incrCount(183264084);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.attend state4 = agent.new attend();
						state4.setTarget(event.get("user"));
						if (!flowThread.callState(state4, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 34, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 36
						Greeting state5 = new Greeting();
						flowThread.gotoState(state5, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 36, 28)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 34, 36));
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
			// Line: 41
			try {
				EXECUTION: {
					int count = getCount(460332449) + 1;
					incrCount(460332449);
					// Line: 42
					boolean chosen6 = false;
					boolean matching7 = true;
					while (!chosen6 && matching7) {
						int rand8 = random(1919892312, 3, iristk.util.RandomList.RandomModel.DECK_RESHUFFLE_NOREPEAT);
						matching7 = false;
						if (true) {
							matching7 = true;
							if (rand8 >= 0 && rand8 < 1) {
								chosen6 = true;
								iristk.situated.SystemAgentFlow.say state9 = agent.new say();
								StringCreator string10 = new StringCreator();
								string10.append("Greetings! Do you want to play with me?");
								state9.setText(string10.toString());
								state9.setGesture("smile");
								if (!flowThread.callState(state9, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 42, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
						if (true) {
							matching7 = true;
							if (rand8 >= 1 && rand8 < 2) {
								chosen6 = true;
								iristk.situated.SystemAgentFlow.say state11 = agent.new say();
								StringCreator string12 = new StringCreator();
								string12.append("Hi. I am Furhat! Let's play a game.");
								state11.setText(string12.toString());
								state11.setGesture("smile");
								if (!flowThread.callState(state11, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 42, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
						if (true) {
							matching7 = true;
							if (rand8 >= 2 && rand8 < 3) {
								chosen6 = true;
								iristk.situated.SystemAgentFlow.say state13 = agent.new say();
								StringCreator string14 = new StringCreator();
								string14.append("Hey there! Let's play a game.");
								state13.setText(string14.toString());
								state13.setGesture("smile");
								if (!flowThread.callState(state13, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 42, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
					}
					// Line: 47
					ExplainGame state15 = new ExplainGame();
					flowThread.gotoState(state15, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 47, 31)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 41, 12));
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
			// Line: 52
			try {
				EXECUTION: {
					int count = getCount(358699161) + 1;
					incrCount(358699161);
					iristk.situated.SystemAgentFlow.say state16 = agent.new say();
					StringCreator string17 = new StringCreator();
					string17.append("I am going on holidays. I need to pack some stuff. Do you want to help?");
					state16.setText(string17.toString());
					if (!flowThread.callState(state16, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 52, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 54
					PackIntro state18 = new PackIntro();
					flowThread.gotoState(state18, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 54, 29)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 52, 12));
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
			// Line: 59
			try {
				EXECUTION: {
					int count = getCount(110718392) + 1;
					incrCount(110718392);
					iristk.situated.SystemAgentFlow.say state19 = agent.new say();
					StringCreator string20 = new StringCreator();
					string20.append("I pack my bags and I take with me:");
					// Line: 59
					string20.append(packables.first());
					state19.setText(string20.toString());
					if (!flowThread.callState(state19, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 59, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 59, 12));
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
			// Line: 69
			try {
				EXECUTION: {
					int count = getCount(1100439041) + 1;
					incrCount(1100439041);
					iristk.situated.SystemAgentFlow.say state21 = agent.new say();
					StringCreator string22 = new StringCreator();
					string22.append("Do you want to play again?");
					state21.setText(string22.toString());
					if (!flowThread.callState(state21, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 69, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state23 = agent.new listen();
					if (!flowThread.callState(state23, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 69, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 69, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 73
			try {
				count = getCount(204349222) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(204349222);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state24 = agent.new say();
							StringCreator string25 = new StringCreator();
							string25.append("Okay, let's play again.");
							state24.setText(string25.toString());
							if (!flowThread.callState(state24, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 73, 58)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 75
							PackIntro state26 = new PackIntro();
							flowThread.gotoState(state26, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 75, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 73, 58));
			}
			// Line: 77
			try {
				count = getCount(114935352) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(114935352);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state27 = agent.new say();
							StringCreator string28 = new StringCreator();
							string28.append("Okay, goodbye");
							state27.setText(string28.toString());
							if (!flowThread.callState(state27, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 77, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 79
							Idle state29 = new Idle();
							flowThread.gotoState(state29, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 79, 24)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 77, 57));
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
			// Line: 84
			try {
				count = getCount(1973538135) + 1;
				if (event.triggers("sense.user.speech.start")) {
					if (system.isAttending(event) && eq(event.get("speakers"), 1)) {
						incrCount(1973538135);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.gesture state30 = agent.new gesture();
							state30.setName("smile");
							if (!flowThread.callState(state30, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 84, 102)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 84, 102));
			}
			// Line: 87
			try {
				count = getCount(1023487453) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(1023487453);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state31 = agent.new say();
						StringCreator string32 = new StringCreator();
						string32.append("Sorry, I didn't get that.");
						state31.setText(string32.toString());
						if (!flowThread.callState(state31, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 87, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 89
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 89, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 87, 36));
			}
			// Line: 91
			try {
				count = getCount(515132998) + 1;
				if (event.triggers("sense.user.speak.side")) {
					incrCount(515132998);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.attendOther state33 = agent.new attendOther();
						state33.setMode("eyes");
						if (!flowThread.callState(state33, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 91, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						iristk.situated.SystemAgentFlow.say state34 = agent.new say();
						StringCreator string35 = new StringCreator();
						string35.append("I didn't ask you.");
						state34.setText(string35.toString());
						if (!flowThread.callState(state34, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 91, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						iristk.situated.SystemAgentFlow.attendOther state36 = agent.new attendOther();
						state36.setMode("eyes");
						if (!flowThread.callState(state36, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 91, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 95
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 95, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 91, 41));
			}
			// Line: 97
			try {
				count = getCount(1586600255) + 1;
				if (event.triggers("sense.user.speak.multi")) {
					incrCount(1586600255);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state37 = agent.new say();
						StringCreator string38 = new StringCreator();
						string38.append("Don't speak at the same time.");
						state37.setText(string38.toString());
						if (!flowThread.callState(state37, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 97, 42)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 99
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 99, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 97, 42));
			}
			// Line: 101
			try {
				count = getCount(932583850) + 1;
				if (event.triggers("sense.user.silence")) {
					incrCount(932583850);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state39 = agent.new say();
						StringCreator string40 = new StringCreator();
						string40.append("Sorry, I didn't hear anything.");
						state39.setText(string40.toString());
						if (!flowThread.callState(state39, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 101, 38)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 103
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 103, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 101, 38));
			}
			// Line: 105
			try {
				count = getCount(1579572132) + 1;
				if (event.triggers("sense.user.leave")) {
					if (system.isAttending(event)) {
						incrCount(1579572132);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 106
							if (system.hasUsers()) {
								iristk.situated.SystemAgentFlow.attendRandom state41 = agent.new attendRandom();
								if (!flowThread.callState(state41, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 106, 33)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 109
							} else {
								// Line: 110
								Idle state42 = new Idle();
								flowThread.gotoState(state42, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 110, 25)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 105, 69));
			}
			// Line: 113
			try {
				count = getCount(292938459) + 1;
				if (event.triggers("repeat")) {
					incrCount(292938459);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 114
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 114, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 113, 26));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


}
