function Header() {
  return (
    <div className="container-fluid">
      <div className="row search-header">
        <div className="col-sm-5 search-header-generic search-header-searchbar">
          <input
            type="search"
            className="searchbar"
            placeholder="keresés"
            name="query"
          />
          <button className="btn-submit">
            <i className="fa-solid fa-magnifying-glass btn-submit"></i>
          </button>
        </div>
        <div className="col-sm-1 search-header-generic">
          <input type="checkbox" className="checkbox" name="option1" />
          <label className="checkbox-label"> üsző</label>
        </div>
        <div className="col-sm-1 search-header-generic">
          <input type="checkbox" className="checkbox" name="option2" />
          <label className="checkbox-label"> bika</label>
        </div>
        <div className="col-sm-2 search-header-generic">
          <select name="breed" className="dropdown-generic">
            <option value="all" selected>
              minden fajta
            </option>
          </select>
        </div>
        <div className="col-sm-2 search-header-generic">
          <select name="type" className="dropdown-generic">
            <option value="all" selected>
              minden típus
            </option>
          </select>
        </div>
        <div className="col-sm-1 search-header-plus-btn">
          <button className="btn-plus">
            <i className="fa-solid fa-plus"></i>
          </button>
        </div>
      </div>
    </div>
  );
}

export default Header;
