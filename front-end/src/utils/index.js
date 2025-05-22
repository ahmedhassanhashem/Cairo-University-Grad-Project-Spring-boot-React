import jwtDecode from "jwt-decode";

export function getBase64Image(img) {
  var canvas = document.createElement("canvas");
  canvas.width = img.width + 300;
  canvas.height = img.height + 300;
  var ctx = canvas.getContext("2d");
  ctx.drawImage(img, 0, 0);
  var dataURL = canvas.toDataURL("image/png");
  return dataURL.replace(/^data:img\/?[A-z]*;base64,/);
}

export const getDataFromForm = (form) => {
  const formData = new FormData(form);

  return Object.fromEntries(formData);
};

export const citiesMapping = {
  1: "Cairo",
  2: "Giza",
  3: "Alex",
};

export const userInfoFactory = (info, profilePicture, user) => {
  const { jti } = user;
  const {
    seekerName,
    email,
    summary = "",
    dateOfBirth,
    address,
    position,
    city,
    linkedin,
    mobileNumber,
  } = info;

  return {
    user: {
      id: jti,
    },
    id: jti,
    seekerName,
    email,
    summary,
    dateOfBirth: dateOfBirth,
    mobileNumber,
    profile: getBase64Image(profilePicture.current),
    links: {
      id: user.jti,
      linkedin,
    },
    address,
    country: {
      id: 101,
      name: "EGYPT",
    },
    city: {
      id: 1001,
      name: citiesMapping[city],
    },
    position,
  };
};

export const companyInfoFactory = (info, profilePicture, user) => {
  const { jti } = user;
  const {
    companyName,
    foundedDate,
    description,
    email,
    zip,
    industry,
    address,
    facebook = "",
    twitter = "",
    website = "",
    dateOfBirth,
    position,
    city,
    linkedin,
    mobileNumber,
  } = info;
  return {
    user: {
      id: jti,
    },
    id: jti,
    companyName,
    foundedDate,
    email,
    description,
    dateOfBirth: dateOfBirth,
    mobileNumber,
    profile: getBase64Image(profilePicture.current),
    links: {
      id: user.jti,
      linkedin,
      facebook,
      twitter,
      website,
    },
    zip,
    industry: {
      id: 102,
      name: industry.name,
    },
    address,
    country: {
      id: 101,
      name: "EGYPT",
    },
    city: {
      id: 1001,
      name: citiesMapping[city],
    },
    position,
  };
};

export const getPasswordPattren = () => {
  return /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/;
};

export const getUserToken = () => localStorage.getItem("token");

export const getUser = () => {
  const token = getUserToken();
  return token ? jwtDecode(token) : {};
};
