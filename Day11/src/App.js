import React from 'react';
import { Provider } from 'react-redux';
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Register from './SignUp/Register';
import Navbar from './Home/Navbar'; 
import Login from './SignUp/Login';
import store from './store';
import Dashboard from './Home/Dashboard';
import Search from './Home/Search';
import Favorites from './Home/Favorites';
import Footer from './Home/Footer';
import AdminDashboard from './Footer/AdminDashboard';
import MovieDetails from './Movie/MovieDetails';
import { MovieProvider } from './MovieContext';
import Genre from './Home/Genre';
import PrivacyPolicy from './Footer/PrivacyPolicy';
import TermsAndConditions from './Footer/Terms';
import AboutUs from './Footer/AboutUs';
import Faq from './Footer/Faq';
import Contact from './Footer/Contact';
import Trending from './Home/Trending';

const App = () => {
  return (
<Provider store={store}>
  <div>
    <Router>
    <MovieProvider>
    <Navbar /> 
      <Routes>
        <Route exact path="/" element={<Login />} />
        <Route exact path="/reg" element={<Register />} />
        <Route exact path="/search" element={<Search/>} />
        <Route exact path="/fav" element={<Favorites/>} />
        <Route exact path="/genre" element={<Genre/>} />
        <Route exact path="/dashboard" element={<Dashboard />} />
        <Route exact path="/trending" element={<Trending />} />
        <Route exact path="/movie/:id" element={<MovieDetails/>} />
        <Route exact path="/terms" element={<TermsAndConditions/>} />
        <Route path="/privacy-policy" element={<PrivacyPolicy/>} />
        <Route path="/aboutus" element={<AboutUs/>} />
        <Route path="/faq" element={<Faq/>} />
        <Route path="/contact" element={<Contact/>} />
        <Route path="/admin" element={<AdminDashboard/>} />
      </Routes>
    <Footer />
    </MovieProvider>
    </Router>
  </div>
</Provider>
);
};

export default App;
