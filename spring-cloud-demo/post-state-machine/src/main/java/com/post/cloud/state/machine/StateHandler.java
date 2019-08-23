package com.post.cloud.state.machine;import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Component;

import com.post.cloud.state.machine.entity.StateEntity;
import com.post.cloud.state.machine.entity.StateMessage;
import com.post.cloud.state.machine.enums.Events;
import com.post.cloud.state.machine.enums.States;

@Component("stateHandler")
public class StateHandler {
    @Autowired
    private ObjectFactory<StateMachine<States, Events>> stateMachineObjectFactory;

    public StateMachine<States, Events> getStateMachine() {
        return stateMachineObjectFactory.getObject();
    }

    public void sendEvent(Events event, StateEntity entity) {
        StateMachine<States, Events> stateMachine = getStateMachine();

        sendEvent(stateMachine, event, entity);
    }

    public void sendEvent(StateMachine<States, Events> stateMachine, Events event, StateEntity entity) {
        boolean result = stateMachine.sendEvent(new StateMessage<Events>(event, entity));

        if (!result) {
            throw new StateException("Not match with correct state flow, source state=[" + entity.getSourceState() + "], event=[" + event + "] to send failed");
        }
    }
}
