// Select the chat with person2 and make it active
document.querySelector('.chat[data-chat=person2]').classList.add('active-chat');
// Select the person with data-chat attribute equal to person2 and make it active
document.querySelector('.person[data-chat=person2]').classList.add('active');
// Define an object to store information about friends
var friends = {
      // Select the unordered list of people
      list: document.querySelector('ul.people'),
      // Select all people in the left column
      all: document.querySelectorAll('.left .person'),
      // Initialize the name property to an empty string
      name: '' },
    // Define an object to store information about the chat
    chat = {
      // Select the container of the chat
      container: document.querySelector('.container .right'),
      // Initialize the current property to null
      current: null,
      // Initialize the person property to null
      person: null,
      // Select the element to display the name of the current chat
      name: document.querySelector('.container .right .top .name') };

// Loop through all people in the left column and add an event listener for mousedown event
friends.all.forEach(function (f) {
  f.addEventListener('mousedown', function () {
    // If the person is not already active, make it active
    f.classList.contains('active') || setAciveChat(f);
  });
});

// Define a function to set the active chat
function setAciveChat(f) {
    // Remove the active class from the currently active person
    friends.list.querySelector('.active').classList.remove('active');
    // Add the active class to the selected person
    f.classList.add('active');
    // Set the current chat to the active chat container
    chat.current = chat.container.querySelector('.active-chat');
    // Set the person property to the data-chat attribute of the selected person
    chat.person = f.getAttribute('data-chat');
    // Remove the active class from the currently active chat container
    chat.current.classList.remove('active-chat');
    // Add the active class to the chat container corresponding to the selected person
    chat.container.querySelector('[data-chat="' + chat.person + '"]').classList.add('active-chat');
    // Set the name property of the friends object to the name of the selected person
    friends.name = f.querySelector('.name').innerText;
    // Display the name of the selected person in the chat header
    chat.name.innerHTML = friends.name;
}