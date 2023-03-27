describe('New Ad Post', () => {
  beforeEach(() => {
    cy.visit('http://localhost:5173/newItem');
  });

  it('should display an error message when required fields are empty', () => {
    cy.get('button').contains('Publish Item').click();
    cy.get('.error-message').should('contain', 'Please fill in all mandatory fields');
  });

  it('should upload an image and display an error message when brief description is longer than 42 characters and other fields are filled', () => {
    cy.intercept('http://localhost:9090/api/categories/getCategories').as('getCategories');
  
    cy.visit('http://localhost:5173/newItem');
    cy.wait('@getCategories');
  
    cy.fixture('logotest.png', 'base64').then(fileContent => {
      cy.get('#images').attachFile({
        fileContent,
        fileName: 'logotest.png',
        mimeType: 'image/png',
        encoding: 'base64',
      });
    });

      cy.get('#full-description').type('Sample Full Description');
      cy.get('#location').type('New York');
      cy.get('#price').type('100');
    
      cy.get('#brief-description').type('This description is longer than 42 characters, which is not allowed');
    
      cy.get('button').contains('Publish Item').click();
      cy.get('.error-message',{ timeout: 10000 }).should('contain', 'Breif Description can not be longer than 42 characters');
    });
    

    it('should successfully submit a new ad', () => {
      cy.intercept('GET', '**/api/categories/getCategories', {
        statusCode: 200,
        body: [
          { categoryName: 'Category 1' },
          { categoryName: 'Category 2' },
        ],
      }).as('getCategories');
    
      cy.intercept('POST', '/api/items/add', {
        statusCode: 200,
      });
    
      cy.visit('http://localhost:5173/newItem');
      cy.wait('@getCategories');
    
      cy.get('#brief-description').type('Sample Brief Description');
      cy.get('#category').select('Category 1');
      cy.get('#full-description').type('Sample Full Description');
      cy.get('#location').type('New York');
      cy.get('#price').type('100');
    
      cy.get('button').contains('Publish Item').click();
      cy.url().should('include', '/');
    });
    
});
