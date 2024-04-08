<template>
  <div class="about">
    <h1>This is an about page</h1>

    <div id = "sse">
      <button @click="WebSocketTest">--- 클릭해야 Run WebSocket</button>
    </div>

  </div>
</template>

<script>
export default {
  methods: {
   async WebSocketTest() {
      if ("WebSocket" in window) {
        console.log("WebSocket is supported by your Browser!");

        const ws = new WebSocket("ws://localhost:8083/events");

        ws.onopen = function () {
          // WebSocket 연결이 열린 후에 메시지를 보냄
          ws.send("My message");
          console.log("Message is sent...");
        };

        ws.onmessage = function (evt) {
          const received_msg = evt.data;
          console.log("Message is received...");
        };

        ws.onclose = function () {
          console.log("Connection is closed...");
        };
      } else {
        console.log("WebSocket NOT supported by your Browser!");
      }// --if
    }
  }
}

</script>
