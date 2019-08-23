package com.post.cloud.state.machine;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.statemachine.StateMachine;

import com.post.cloud.state.machine.entity.StateEntity;
import com.post.cloud.state.machine.enums.Events;
import com.post.cloud.state.machine.enums.States;

@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    private StateHandler stateHandler;

    @Override
    public void run(String... args) throws Exception {
        test1();
        test2();
    }

    private void test1() throws Exception {
        StateEntity entity = new StateEntity();
        entity.setName("审核通过发送");
        entity.setSourceState(States.STATE_WAIT_AUDIT);

        // 处理同一个对象的状态，必须是同一个状态机
        StateMachine<States, Events> stateMachine = stateHandler.getStateMachine();
        stateHandler.sendEvent(stateMachine, Events.EVENT_AUDIT_PASS, entity);
        stateHandler.sendEvent(stateMachine, Events.EVENT_SEND, entity);
    }

    private void test2() throws Exception {
        StateEntity entity = new StateEntity();
        entity.setName("审核拒绝删除");
        entity.setSourceState(States.STATE_WAIT_AUDIT);

        // 处理同一个对象的状态，必须是同一个状态机
        StateMachine<States, Events> stateMachine = stateHandler.getStateMachine();
        stateHandler.sendEvent(stateMachine, Events.EVENT_AUDIT_REJECT, entity);
        stateHandler.sendEvent(stateMachine, Events.EVENT_DELETE, entity);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
